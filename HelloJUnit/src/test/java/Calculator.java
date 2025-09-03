/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author luizh
 */
public class Calculator {
    static public double somar (double Numero1, double Numero2) {
        return Numero1 + Numero2;
    }
    
    static public double divisao (double Numero1, double Numero2) {
        if (Numero2 == 0.0) 
            throw new ArithmeticException("Divisor nao pode ser zero");
        else 
            return Numero1 / Numero2;
    }
    
    static public double subtracao (double Numero1, double Numero2) {
        return Numero1 - Numero2;
    }
    
    static public double multiplicar (double Numero1, double Numero2) {
        return Numero1 * Numero2;
    }
}
