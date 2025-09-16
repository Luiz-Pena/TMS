
package com.refactor;

import java.time.LocalDate;

/**
 * EXERCÍCIO: Code Smell - Data Class
 * Objetivo:
 *  - Adicionar comportamento relevante em Customer (ex.: elegibilidade de desconto)
 *  - Mover métodos utilitários dispersos para a própria classe (Move Method)
 * Critério de aceite:
 *  - Menos getters/setters "oco", mais comportamento encapsulado
 */
public class DataClassExample {

    // TODO: transformar esta classe em algo com comportamento útil.
    public static class Customer {
        private String id;
        private String name;
        private LocalDate since;
        private int loyaltyPoints;

        public Customer(String id, String name, LocalDate since, int loyaltyPoints) {
            this.id = id; this.name = name; this.since = since; this.loyaltyPoints = loyaltyPoints;
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public LocalDate getSince() { return since; }
        public int getLoyaltyPoints() { return loyaltyPoints; }
        public void setLoyaltyPoints(int points) { this.loyaltyPoints = points; }
    }
}
