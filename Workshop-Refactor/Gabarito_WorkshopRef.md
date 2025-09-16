# Gabarito + Soluções – Workshop de Refatoração (IntelliJ)

Este documento contém:
- O **passo a passo** (com atalhos do IntelliJ) para cada exercício; e
- As **soluções finais dos métodos** (código) do trabalho inteiro.

> Dica geral: use `Ctrl+Alt+Shift+T` (Win/Linux) · `⌃⌥⇧T` (mac) para abrir **Refactor This…** a partir de qualquer símbolo.

---

## 1) LongMethodExample — *Long Method*
**Arquivo:** `LongMethodExample.java`  
**Objetivo:** encurtar `processOrder` e separar responsabilidades. Adotar `CheckoutOptions` (Parameter Object).

### Passos (IntelliJ)
1. Selecione o cálculo do subtotal → **Extract Method** (`Ctrl+Alt+M` · `⌘⌥M`) → `calculateSubtotal(Order)`.
2. Selecione a regra de cupom → **Extract Method** → `calculateDiscount(double, String)`.
3. Selecione frete → **Extract Method** → `calculateShipping(String)`.
4. Selecione imposto → **Extract Method** → `calculateTax(double)`.
5. (Opcional) **Introduce Parameter Object**: crie `CheckoutOptions` e use **Change Signature** (`Ctrl+F6` · `⌘F6`) para trocar `(Order, String, String)` por `(Order, CheckoutOptions)`.

### Solução (métodos finais)
```java
public double processOrder(Order order, CheckoutOptions opts) {
    double subtotal = calculateSubtotal(order);
    double discount = calculateDiscount(subtotal, opts.couponCode);
    double totalAfterDiscount = subtotal - discount;
    double shipping = calculateShipping(opts.shippingMethod);
    double tax = calculateTax(totalAfterDiscount);
    logOrder(order, subtotal, discount, shipping, tax);
    return totalAfterDiscount + shipping + tax;
}
```

---

## 2) LargeClassExample — *Large Class*
**Arquivos:** `LargeClassExample.java`, `DataLoader.java`, `ReportFilter.java`, `ReportRenderer.java`  
**Objetivo:** quebrar a classe grande em colaborações.

### Passos
- Crie `DataLoader`, `ReportFilter`, `ReportRenderer` (*Alt+Insert* · `⌘N`).  
- **Move** (`F6`) os métodos `load`, `filterByCategory`, `render` para suas classes.  
- `ReportManager` mantém apenas a orquestração.

### Solução (método final em `ReportManager`)
```java
public String run(String category) {
    var data = loader.load();
    List<Record> filtered = filter.byCategory(data, category);
    return renderer.render(filtered);
}
```

---

## 3) DuplicateCodeExample — *Duplicação de Código*
**Arquivos:** `DuplicateCodeExample.java` + `PriceCalculator`  
**Objetivo:** um único ponto de verdade para subtotal/discount/tax.

### Passos
1. **Extract Method** da lógica repetida → `computeTotal(products, coupon)`.
2. Crie `PriceCalculator` e **Move Method** (`F6`) do método extraído para ela.
3. **Inline** (`Ctrl+Alt+N` · `⌘⌥N`) versões antigas, deixando só a delegação.

### Solução (assinaturas finais)
```java
public double calculateCartTotal(List<Product> products, String coupon) {
    return calculator.computeTotal(products, coupon);
}
public double calculateWishlistTotal(List<Product> products, String coupon) {
    return calculator.computeTotal(products, coupon);
}
```

---

## 4) LongParameterListExample — *Long Parameter List*
**Arquivo:** `LongParameterListExample.java`  
**Objetivo:** introduzir `MeetingOptions`.

### Passos
1. Crie `record MeetingOptions(...)` (*Alt+Insert* · `⌘N`).  
2. **Change Signature** (`Ctrl+F6` · `⌘F6`) para `scheduleMeeting(String, MeetingOptions)`.

### Solução (assinatura + uso)
```java
public record MeetingOptions(LocalDate date, LocalTime start, LocalTime end,
                             String room, boolean online, String meetingLink,
                             List<String> participants) {}

public String scheduleMeeting(String title, MeetingOptions opts) {
    String mode = opts.online() ? ("ONLINE (" + opts.meetingLink() + ")") : ("ROOM " + opts.room());
    return "%s on %s from %s to %s, %s, participants=%d"
            .formatted(title, opts.date(), opts.start(), opts.end(), mode, opts.participants().size());
}
```

---

## 5) DataClumpsExample — *Data Clumps*
**Arquivo:** `DataClumpsExample.java`  
**Objetivo:** substituir `street/city/zip` por `Address`.

### Passos
1. **Extract Class** manual: crie `Address(street, city, zip)`.  
2. Troque os trios por `Address address`.

### Solução (definição central)
```java
public static class Address {
    public final String street, city, zip;
    public Address(String street, String city, String zip) { this.street = street; this.city = city; this.zip = zip; }
    @Override public String toString() { return street + ", " + city + " - " + zip; }
}
```

---

## 6) ConditionalDivergenceExample — *Replace Conditional with Polymorphism*
**Arquivo:** `ConditionalDivergenceExample.java`  
**Objetivo:** remover o `switch` e usar polimorfismo no `enum` (ou Strategy).

### Passos
- (Opcional) **Extract Method** dos cálculos.  
- Implemente `fee(double)` em cada constante do `enum`.  
- Troque `switch` por `return type.fee(amount);`.

### Solução (método final + enum)
```java
public enum AccountType {
    BASIC { @Override public double fee(double amount){ return amount * 0.02 + 1.0; } },
    PREMIUM { @Override public double fee(double amount){ return amount * 0.015 + 0.5; } },
    ENTERPRISE { @Override public double fee(double amount){ return amount * 0.01; } };
    public abstract double fee(double amount);
}
public double computeFee(AccountType type, double amount) { return type.fee(amount); }
```

---

## 7) FeatureEnvyExample — *Feature Envy*
**Arquivo:** `FeatureEnvyExample.java`  
**Objetivo:** mover formatação para `Order` e delegar no `OrderPrinter`.

### Passos
- **Move Method** (`F6`) do que estava em `OrderPrinter` para `Order` (ou reimplemente lá e **Inline** o antigo).

### Solução (método final)
```java
public static class Order {
    // ...
    public String toReceipt() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER ").append(id).append(" - ").append(date).append('\n');
        for (OrderItem it : items) {
            sb.append(it.qty).append("x ").append(it.name).append(" = ").append(it.total()).append('\n');
        }
        sb.append("TOTAL: ").append(total());
        return sb.toString();
    }
}
public static class OrderPrinter {
    public String print(Order o) { return o.toReceipt(); }
}
```

---

## 8) DataClassExample — *Data Class*
**Arquivo:** `DataClassExample.java`  
**Objetivo:** adicionar comportamento e invariantes a `Customer`.

### Passos
- **Encapsulate Fields** (opcional) e crie métodos de domínio: `discountRate`, `applyPurchase`, `addLoyalty`, `rename`.  
- Valide entradas e centralize as regras.

### Solução (métodos principais)
```java
public double discountRate() {
    int years = Period.between(since, LocalDate.now()).getYears();
    double byYears = years >= 5 ? 0.05 : years >= 2 ? 0.02 : 0.0;
    double byPoints = loyaltyPoints >= 1000 ? 0.05 : loyaltyPoints >= 500 ? 0.02 : 0.0;
    return Math.min(0.15, byYears + byPoints);
}
public double applyPurchase(double amount) {
    if (amount < 0) throw new IllegalArgumentException("amount");
    double paid = amount * (1.0 - discountRate());
    addLoyalty((int)Math.floor(amount));
    return Math.round(paid * 100.0) / 100.0;
}
public int addLoyalty(int points) {
    if (points < 0) return loyaltyPoints;
    this.loyaltyPoints += points;
    return this.loyaltyPoints;
}
```

---


