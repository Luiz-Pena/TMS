
package com.refactor;

/**
 * EXERCÍCIO: Code Smell - Desvio Condicional (switch/if by type)
 * Objetivo:
 *  - Replace Conditional with Polymorphism: criar hierarquia Account
 * Critério de aceite:
 *  - Eliminar switch em computeFee
 */
public class ConditionalDivergenceExample {

    public enum AccountType { BASIC, PREMIUM, ENTERPRISE }

    // TODO: substituir este switch por polimorfismo (subclasses ou Strategy).
    public double computeFee(AccountType type, double amount) {
        switch (type) {
            case BASIC: return amount * 0.02 + 1.0;
            case PREMIUM: return amount * 0.015 + 0.5;
            case ENTERPRISE: return amount * 0.01;
            default: throw new IllegalArgumentException("unknown type");
        }
    }
}
