package test;

import org.junit.jupiter.api.Test;

import Calculadora.Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    
    private Calculator calculadora;
    
    @BeforeEach
    void setUp() {
        calculadora = new Calculator();
    }
    
    @Test
    @DisplayName("Soma de números inteiros")
    void testSomarInteiros() {
        assertEquals(5.0, calculadora.somar(2, 3));
        assertEquals(-1.0, calculadora.somar(2, -3));
    }
    
    @Test
    @DisplayName("Soma de números decimais")
    void testSomarDecimais() {
        assertEquals(5.5, calculadora.somar(2.2, 3.3));
        assertEquals(-1.1, calculadora.somar(2.2, -3.3));
    }
    
    @Test
    @DisplayName("Subtração de números")
    void testSubtrair() {
        assertEquals(1.0, calculadora.subtrair(3, 2));
        assertEquals(5.0, calculadora.subtrair(2, -3));
    }
    
    @Test
    @DisplayName("Multiplicação de números")
    void testMultiplicar() {
        assertEquals(6.0, calculadora.multiplicar(2, 3));
        assertEquals(-6.0, calculadora.multiplicar(2, -3));
        assertEquals(0.0, calculadora.multiplicar(5, 0));
    }
    
    @Test
    @DisplayName("Divisão válida")
    void testDividirValida() {
        assertEquals(2.0, calculadora.dividir(6, 3));
        assertEquals(-2.0, calculadora.dividir(6, -3));
        assertEquals(2.5, calculadora.dividir(5, 2));
    }
    
    @Test
    @DisplayName("Divisão por zero deve lançar exceção")
    void testDividirPorZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculadora.dividir(5, 0);
        });
        
        assertThrows(ArithmeticException.class, () -> {
            calculadora.dividir(-5, 0);
        });
    }
    
    @Test
    @DisplayName("Raiz quadrada de números positivos")
    void testRaizQuadradaPositiva() {
        assertEquals(2.0, calculadora.raizQuadrada(4));
        assertEquals(3.0, calculadora.raizQuadrada(9));
        assertEquals(1.414, calculadora.arredondar(calculadora.raizQuadrada(2), 3));
    }
    
    @Test
    @DisplayName("Raiz quadrada de zero")
    void testRaizQuadradaZero() {
        assertEquals(0.0, calculadora.raizQuadrada(0));
    }
    
    @Test
    @DisplayName("Raiz quadrada de número negativo deve lançar exceção")
    void testRaizQuadradaNegativa() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.raizQuadrada(-4);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.raizQuadrada(-1);
        });
    }
    
    @Test
    @DisplayName("Potenciação com expoente positivo")
    void testPotenciaExpoentePositivo() {
        assertEquals(8.0, calculadora.potencia(2, 3));
        assertEquals(1.0, calculadora.potencia(5, 0));
        assertEquals(0.25, calculadora.potencia(0.5, 2));
    }
    
    @Test
    @DisplayName("Potenciação com expoente negativo")
    void testPotenciaExpoenteNegativo() {
        assertEquals(0.125, calculadora.potencia(2, -3));
        assertEquals(4.0, calculadora.potencia(0.5, -2));
    }
    
    @Test
    @DisplayName("Potenciação com base zero")
    void testPotenciaBaseZero() {
        assertEquals(0.0, calculadora.potencia(0, 3));
        assertEquals(1.0, calculadora.potencia(0, 0)); 
    }
    
    @Test
    @DisplayName("Potenciação com base negativa")
    void testPotenciaBaseNegativa() {
        assertEquals(4.0, calculadora.potencia(-2, 2));
        assertEquals(-8.0, calculadora.potencia(-2, 3));
        assertEquals(0.25, calculadora.potencia(-2, -2));
    }
    
    @Test
    @DisplayName("Valores limites - Double.MAX_VALUE")
    void testValoresLimitesMax() {
        assertEquals(Double.MAX_VALUE, calculadora.somar(Double.MAX_VALUE, 0));
        assertEquals(0.0, calculadora.subtrair(Double.MAX_VALUE, Double.MAX_VALUE));
    }
    
    @Test
    @DisplayName("Valores limites - Double.MIN_VALUE")
    void testValoresLimitesMin() {
        assertEquals(Double.MIN_VALUE, calculadora.somar(Double.MIN_VALUE, 0));
        assertEquals(0.0, calculadora.subtrair(Double.MIN_VALUE, Double.MIN_VALUE));
    }
    
    @Test
    @DisplayName("Valores limites - overflow na multiplicação")
    void testOverflowMultiplicacao() {
        double resultado = calculadora.multiplicar(Double.MAX_VALUE, 2);
        assertTrue(Double.isInfinite(resultado));
    }
    
    @Test
    @DisplayName("Valores limites - underflow na multiplicação")
    void testUnderflowMultiplicacao() {
        double resultado = calculadora.multiplicar(Double.MIN_VALUE, 0.5);
        assertEquals(0.0, resultado);
    }
    
    @Test
    @DisplayName("Raiz quadrada de valor máximo")
    void testRaizQuadradaValorMaximo() {
        double resultado = calculadora.raizQuadrada(Double.MAX_VALUE);
        assertTrue(resultado > 0 && !Double.isInfinite(resultado));
    }
    
    @Test
    @DisplayName("Potenciação com valores extremos")
    void testPotenciaValoresExtremos() {
        double resultado1 = calculadora.potencia(2, 1024);
        assertTrue(Double.isInfinite(resultado1));
        
        double resultado2 = calculadora.potencia(0.5, 1024);
        assertEquals(0.0, resultado2);
    }
    
    @Test
    @DisplayName("Teste de arredondamento")
    void testArredondamento() {
        assertEquals(3.14, calculadora.arredondar(3.14159, 2));
        assertEquals(3.142, calculadora.arredondar(3.14159, 3));
        assertEquals(3.0, calculadora.arredondar(3.0, 0));
    }
    
    @Test
    @DisplayName("Arredondamento com casas decimais negativas deve lançar exceção")
    void testArredondamentoCasasNegativas() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.arredondar(3.14, -1);
        });
    }
}