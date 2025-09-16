
package com.refactor;

import java.util.List;

/**
 * EXERCÍCIO: Code Smell - Duplicação de Código
 * Objetivo:
 *  - Extrair lógica de preço/taxa/desconto para um método único (ou classe PriceCalculator)
 *  - Usar Extract Method e Move Method
 * Critério de aceite:
 *  - Remover duplicação entre calculateCartTotal e calculateWishlistTotal
 */
public class DuplicateCodeExample {

    public static class Product {
        public final String name;
        public final double price;
        public Product(String name, double price) { this.name = name; this.price = price; }
    }

    // TODO: eliminar duplicação entre estes dois métodos.
    public double calculateCartTotal(List<Product> products, String coupon) {
        double subtotal = 0.0;
        for (Product p : products) subtotal += p.price;
        double discount = 0.0;
        if (coupon != null && coupon.startsWith("SAVE10")) discount = subtotal * 0.10;
        double taxed = (subtotal - discount) * 1.12; // 12% imposto
        return Math.round(taxed * 100.0) / 100.0;
    }

    public double calculateWishlistTotal(List<Product> products, String coupon) {
        double subtotal = 0.0;
        for (Product p : products) subtotal += p.price;
        double discount = 0.0;
        if (coupon != null && coupon.startsWith("SAVE10")) discount = subtotal * 0.10;
        double taxed = (subtotal - discount) * 1.12; // 12% imposto
        return Math.round(taxed * 100.0) / 100.0;
    }
}
