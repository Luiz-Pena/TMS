
package com.refactor;

import java.time.LocalDate;
import java.util.List;

/**
 * EXERCÍCIO: Code Smell - Long Method
 * Objetivo:
 *  - Usar Extract Method no método processOrder para dividir responsabilidades
 *  - (Opcional) Introduce Parameter Object para agrupar parâmetros de frete/cupom
 * Critério de aceite:
 *  - processOrder deve ficar curto (<= 15 linhas) e legível
 *  - Nenhuma mudança de comportamento
 */
public class LongMethodExample {

    public static class Item {
        public final String name;
        public final int quantity;
        public final double price;
        public Item(String name, int quantity, double price) {
            this.name = name; this.quantity = quantity; this.price = price;
        }
    }

    public static class Order {
        public final String customerId;
        public final List<Item> items;
        public final LocalDate date = LocalDate.now();
        public Order(String customerId, List<Item> items) {
            this.customerId = customerId; this.items = items;
        }
    }

    // TODO: Refatore este método usando Extract Method.
    public double processOrder(Order order, String couponCode, String shippingMethod) {
        // calcular subtotal
        double subtotal = 0.0;
        for (Item i : order.items) {
            subtotal += i.price * i.quantity;
        }

        // aplicar cupom
        double discount = 0.0;
        if (couponCode != null && !couponCode.isBlank()) {
            if (couponCode.startsWith("SAVE10")) discount = subtotal * 0.10;
            else if (couponCode.startsWith("SAVE20")) discount = subtotal * 0.20;
        }
        double totalAfterDiscount = subtotal - discount;

        // calcular frete
        double shipping = 0.0;
        if ("EXPRESS".equalsIgnoreCase(shippingMethod)) shipping = 39.90;
        else if ("STANDARD".equalsIgnoreCase(shippingMethod)) shipping = 19.90;
        else shipping = 29.90;

        // imposto
        double tax = totalAfterDiscount * 0.12;

        // log/trilha (apenas side-effects simulados)
        System.out.printf("[order=%s] subtotal=%.2f discount=%.2f shipping=%.2f tax=%.2f%n",
                order.customerId, subtotal, discount, shipping, tax);

        // persistir (simulado)
        // save(order)

        return totalAfterDiscount + shipping + tax;
    }
}
