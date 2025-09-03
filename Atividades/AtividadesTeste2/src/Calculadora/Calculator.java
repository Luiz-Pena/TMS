package Calculadora;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
	
	public double multiplicar (double x, double y) {
		return x*y;
	}
	
	public int multiplicar (int x, int y) {
		return x*y;
	}
	
	public double dividir (double x, double y) {
		if (y == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida");
        }
		
		return x/y;
	}
	
	public int dividir (int x, int y) {
		if (y == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida");
        }
		
		return x/y;
	}
	
	public double somar (double x, double y) {
		return x+y;
	}
	
	public int somar (int x, int y) {
		return x+y;
	}
	
	public double subtrair (double x, double y) {
		return x - y;
	}
	
	public int subtrair (int x, int y) {
		return x - y;
	}
	
	public double raizQuadrada(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Não é possível calcular raiz quadrada de número negativo");
        }
        return Math.sqrt(x);
    }
	
	public double potencia(double base, double expoente) {
        return Math.pow(base, expoente);
    }
    
    public double arredondar(double valor, int casasDecimais) {
        if (casasDecimais < 0) {
            throw new IllegalArgumentException("Número de casas decimais não pode ser negativo");
        }
        BigDecimal bd = new BigDecimal(Double.toString(valor));
        bd = bd.setScale(casasDecimais, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
	
}
