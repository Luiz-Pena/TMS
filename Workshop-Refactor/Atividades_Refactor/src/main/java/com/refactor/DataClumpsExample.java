
package com.refactor;

/**
 * EXERCÍCIO: Code Smell - Data Clumps
 * Objetivo:
 *  - Criar classe Address e substituir grupos de campos repetidos
 * Critério de aceite:
 *  - Reduzir repetição dos trios street/city/zip
 */
public class DataClumpsExample {

    // TODO: substituir os 3 campos por Address em ambas as classes.
    public static class Customer {
        public String street;
        public String city;
        public String zip;
        public String name;
    }

    public static class Supplier {
        public String street;
        public String city;
        public String zip;
        public String companyName;
    }
}
