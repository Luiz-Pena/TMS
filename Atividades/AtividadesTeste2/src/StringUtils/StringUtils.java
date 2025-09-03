package StringUtils;

public class StringUtils {
	public String inverterString(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String não pode ser nula");
        }
        return new StringBuilder(str).reverse().toString();
    }
	
	public int contarOcorrencias(String str, char caractere) {
        if (str == null) {
            throw new IllegalArgumentException("String não pode ser nula");
        }
        
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == caractere) {
                count++;
            }
        }
        return count;
    }
	
	public boolean isPalindromo(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String não pode ser nula");
        }
        
        String textoLimpo = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (textoLimpo.isEmpty()) {
            return true;
        }
        
        String invertida = inverterString(textoLimpo);
        return textoLimpo.equals(invertida);
    }
	
	public String paraMaiusculas(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String não pode ser nula");
        }
        return str.toUpperCase();
    }
	
	public String paraMinusculas(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String não pode ser nula");
        }
        return str.toLowerCase();
    }
	
	public boolean isVaziaOuNula(String str) {
        return str == null || str.trim().isEmpty();
    }
	
	public String removerEspacos(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String não pode ser nula");
        }
        return str.replaceAll("\\s+", "");
    }
}
