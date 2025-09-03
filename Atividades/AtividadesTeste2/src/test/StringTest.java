package test;

import org.junit.jupiter.api.Test;

import StringUtils.StringUtils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class StringTest {
    
    private StringUtils stringUtils;
    
    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    
    @Test
    @DisplayName("Inverter string vazia")
    void testInverterStringVazia() {
        assertEquals("", stringUtils.inverterString(""));
    }
    
    @Test
    @DisplayName("Contar ocorrências em string vazia")
    void testContarOcorrenciasStringVazia() {
        assertEquals(0, stringUtils.contarOcorrencias("", 'a'));
    }
    
    @Test
    @DisplayName("Verificar palíndromo em string vazia")
    void testIsPalindromoStringVazia() {
        assertTrue(stringUtils.isPalindromo(""));
    }
    
    @Test
    @DisplayName("Converter string vazia para maiúsculas")
    void testParaMaiusculasStringVazia() {
        assertEquals("", stringUtils.paraMaiusculas(""));
    }
    
    @Test
    @DisplayName("Converter string vazia para minúsculas")
    void testParaMinusculasStringVazia() {
        assertEquals("", stringUtils.paraMinusculas(""));
    }

    
    @Test
    @DisplayName("Inverter string nula deve lançar exceção")
    void testInverterStringNula() {
        assertThrows(IllegalArgumentException.class, () -> {
            stringUtils.inverterString(null);
        });
    }
    
    @Test
    @DisplayName("Contar ocorrências em string nula deve lançar exceção")
    void testContarOcorrenciasStringNula() {
        assertThrows(IllegalArgumentException.class, () -> {
            stringUtils.contarOcorrencias(null, 'a');
        });
    }
    
    @Test
    @DisplayName("Verificar palíndromo em string nula deve lançar exceção")
    void testIsPalindromoStringNula() {
        assertThrows(IllegalArgumentException.class, () -> {
            stringUtils.isPalindromo(null);
        });
    }
    
    @Test
    @DisplayName("Converter string nula para maiúsculas deve lançar exceção")
    void testParaMaiusculasStringNula() {
        assertThrows(IllegalArgumentException.class, () -> {
            stringUtils.paraMaiusculas(null);
        });
    }
    
    @Test
    @DisplayName("Converter string nula para minúsculas deve lançar exceção")
    void testParaMinusculasStringNula() {
        assertThrows(IllegalArgumentException.class, () -> {
            stringUtils.paraMinusculas(null);
        });
    }
    
    @Test
    @DisplayName("Inverter string com caracteres especiais")
    void testInverterStringCaracteresEspeciais() {
        assertEquals("!@#$%", stringUtils.inverterString("%$#@!"));
        assertEquals("çãõé", stringUtils.inverterString("éõãç"));
        assertEquals("ñáéíóú", stringUtils.inverterString("úóíéáñ"));
    }
    
    @Test
    @DisplayName("Contar ocorrências de caracteres especiais")
    void testContarOcorrenciasCaracteresEspeciais() {
        assertEquals(2, stringUtils.contarOcorrencias("café & café", 'é'));
        assertEquals(3, stringUtils.contarOcorrencias("!!!alert!!!", '!'));
        assertEquals(1, stringUtils.contarOcorrencias("número: 123", 'ç'));
    }
    
    @Test
    @DisplayName("Verificar palíndromo com caracteres especiais")
    void testIsPalindromoCaracteresEspeciais() {
        assertTrue(stringUtils.isPalindromo("A man, a plan, a canal: Panama!"));
        assertTrue(stringUtils.isPalindromo("Socorram-me, subi no ônibus em Marrocos!"));
        assertFalse(stringUtils.isPalindromo("Hello, World!"));
    }
    
    @Test
    @DisplayName("Converter string com caracteres especiais para maiúsculas")
    void testParaMaiusculasCaracteresEspeciais() {
        assertEquals("CAFÉ", stringUtils.paraMaiusculas("café"));
        assertEquals("ÇÃÕÉ", stringUtils.paraMaiusculas("çãõé"));
        assertEquals("ÑÁÉÍÓÚ", stringUtils.paraMaiusculas("ñáéíóú"));
    }
    
    @Test
    @DisplayName("Converter string com caracteres especiais para minúsculas")
    void testParaMinusculasCaracteresEspeciais() {
        assertEquals("café", stringUtils.paraMinusculas("CAFÉ"));
        assertEquals("çãõé", stringUtils.paraMinusculas("ÇÃÕÉ"));
        assertEquals("ñáéíóú", stringUtils.paraMinusculas("ÑÁÉÍÓÚ"));
    }
    
    @Test
    @DisplayName("Inverter strings curtas")
    void testInverterStringsCurtas() {
        assertEquals("a", stringUtils.inverterString("a"));
        assertEquals("ab", stringUtils.inverterString("ba"));
        assertEquals("abc", stringUtils.inverterString("cba"));
    }
    
    @Test
    @DisplayName("Contar ocorrências em strings curtas")
    void testContarOcorrenciasStringsCurtas() {
        assertEquals(1, stringUtils.contarOcorrencias("a", 'a'));
        assertEquals(0, stringUtils.contarOcorrencias("a", 'b'));
        assertEquals(2, stringUtils.contarOcorrencias("aba", 'a'));
    }
    
    @Test
    @DisplayName("Verificar palíndromo em strings curtas")
    void testIsPalindromoStringsCurtas() {
        assertTrue(stringUtils.isPalindromo("a"));
        assertTrue(stringUtils.isPalindromo("aa"));
        assertTrue(stringUtils.isPalindromo("aba"));
        assertFalse(stringUtils.isPalindromo("ab"));
    }
    
    @Test
    @DisplayName("Converter strings curtas para maiúsculas")
    void testParaMaiusculasStringsCurtas() {
        assertEquals("A", stringUtils.paraMaiusculas("a"));
        assertEquals("AB", stringUtils.paraMaiusculas("ab"));
        assertEquals("ABC", stringUtils.paraMaiusculas("abc"));
    }
    
    @Test
    @DisplayName("Converter strings curtas para minúsculas")
    void testParaMinusculasStringsCurtas() {
        assertEquals("a", stringUtils.paraMinusculas("A"));
        assertEquals("ab", stringUtils.paraMinusculas("AB"));
        assertEquals("abc", stringUtils.paraMinusculas("ABC"));
    }

    
    @Test
    @DisplayName("Strings com números")
    void testStringsComNumeros() {
        assertEquals("123", stringUtils.inverterString("321"));
        assertEquals(2, stringUtils.contarOcorrencias("123123", '1'));
        assertTrue(stringUtils.isPalindromo("12321"));
        assertEquals("123", stringUtils.paraMaiusculas("123"));
        assertEquals("123", stringUtils.paraMinusculas("123"));
    }
    
    @Test
    @DisplayName("Strings com espaços múltiplos")
    void testStringsComEspacosMultiplos() {
        assertEquals("  ", stringUtils.inverterString("  "));
        assertEquals(3, stringUtils.contarOcorrencias("a   b", ' '));
        assertTrue(stringUtils.isPalindromo("a   a")); 
    }
    
    @Test
    @DisplayName("Strings com apenas espaços")
    void testStringsApenasEspacos() {
        assertEquals("   ", stringUtils.inverterString("   "));
        assertEquals(3, stringUtils.contarOcorrencias("   ", ' '));
        assertTrue(stringUtils.isPalindromo("   ")); 
    }
    
    @Test
    @DisplayName("Strings com caracteres Unicode")
    void testStringsComUnicode() {
        String emoji1 = "\uD83D\uDE0A"; 
        String emoji2 = "\uD83C\uDF0D";
        
        assertEquals(emoji2 + emoji1, stringUtils.inverterString(emoji1 + emoji2));
        assertEquals(1, stringUtils.contarOcorrencias("Hello" + emoji1, emoji1.charAt(0)));
        assertFalse(stringUtils.isPalindromo("a" + emoji1 + "a"));
    }

    
    @Test
    @DisplayName("Verificar se string é vazia ou nula")
    void testIsVaziaOuNula() {
        assertTrue(stringUtils.isVaziaOuNula(null));
        assertTrue(stringUtils.isVaziaOuNula(""));
        assertTrue(stringUtils.isVaziaOuNula("   "));
        assertFalse(stringUtils.isVaziaOuNula("a"));
        assertFalse(stringUtils.isVaziaOuNula(" hello "));
    }
    
    @Test
    @DisplayName("Remover espaços de strings")
    void testRemoverEspacos() {
        assertEquals("abc", stringUtils.removerEspacos("a b c"));
        assertEquals("hello", stringUtils.removerEspacos("  hello  "));
        assertEquals("test", stringUtils.removerEspacos("t e s t"));
        assertEquals("", stringUtils.removerEspacos("   "));
    }
    
    @Test
    @DisplayName("Remover espaços de string nula deve lançar exceção")
    void testRemoverEspacosNula() {
        assertThrows(IllegalArgumentException.class, () -> {
            stringUtils.removerEspacos(null);
        });
    }
    
    @Test
    @DisplayName("Inverter strings longas")
    void testInverterStringsLongasPortugues() {
        String longText = "A programação é a arte de criar soluções através do código. "
                        + "Java é uma linguagem poderosa e versátil para desenvolvimento.";
        
        String expected = ".sonemivlovned arap litsárev e asoredop megagnil amu é avaJ "
                        + ".odigóc od suevart aicneugrás oed arret a é oãçamargorp A";
        
        assertEquals(expected, stringUtils.inverterString(longText));
    }

    @Test
    @DisplayName("Contar ocorrências em strings longas")
    void testContarOcorrenciasStringsLongas() {
        String longText = "A programação é a arte de criar soluções através do código. "
                        + "Java é uma linguagem poderosa e versátil para desenvolvimento.";
        
        assertEquals(8, stringUtils.contarOcorrencias(longText, 'a'));
        assertEquals(6, stringUtils.contarOcorrencias(longText, ' '));
        assertEquals(2, stringUtils.contarOcorrencias(longText, 'é'));
        assertEquals(2, stringUtils.contarOcorrencias(longText, '.'));
    }

    @Test
    @DisplayName("Verificar palíndromo em strings longas")
    void testIsPalindromoStringsLongas() {
        String palindromoLongo = "A base do teto desaba";
        assertTrue(stringUtils.isPalindromo(palindromoLongo));
        
        String outroPalindromo = "Anotaram a data da maratona";
        assertTrue(stringUtils.isPalindromo(outroPalindromo));
        
        String naoPalindromo = "A programação é a arte de criar soluções através do código";
        assertFalse(stringUtils.isPalindromo(naoPalindromo));
    }

    @Test
    @DisplayName("Converter strings longas para maiúsculas")
    void testParaMaiusculasStringsLongas() {
        String longText = "A programação em java é essencial para desenvolvimento web";
        String expected = "A PROGRAMAÇÃO EM JAVA É ESSENCIAL PARA DESENVOLVIMENTO WEB";
        
        assertEquals(expected, stringUtils.paraMaiusculas(longText));
    }

    @Test
    @DisplayName("Converter strings longas para minúsculas")
    void testParaMinusculasStringsLongas() {
        String longText = "A PROGRAMAÇÃO EM JAVA É ESSENCIAL PARA DESENVOLVIMENTO WEB";
        String expected = "a programação em java é essencial para desenvolvimento web";
        
        assertEquals(expected, stringUtils.paraMinusculas(longText));
    }

    @Test
    @DisplayName("Teste com caracteres acentuados")
    void testCaracteresAcentuados() {
        String texto = "ção áéíóú âêîôû àèìòù äëïöü ç";
        
        String invertida = stringUtils.inverterString(texto);
        assertEquals("ç üöïëä ùòìèà ûôîêâ úóíéá oãç", invertida);
        
        assertEquals(1, stringUtils.contarOcorrencias(texto, 'ç'));
        assertEquals(1, stringUtils.contarOcorrencias(texto, 'á'));
        assertEquals(1, stringUtils.contarOcorrencias(texto, 'â'));
        
        assertEquals("ÇÃO ÁÉÍÓÚ ÂÊÎÔÛ ÀÈÌÒÙ ÄËÏÖÜ Ç", stringUtils.paraMaiusculas(texto));
        assertEquals("ção áéíóú âêîôû àèìòù äëïöü ç", stringUtils.paraMinusculas("ÇÃO ÁÉÍÓÚ ÂÊÎÔÛ ÀÈÌÒÙ ÄËÏÖÜ Ç"));
    }
}
