package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

import Usuario.ExceededAttemptsException;
import Usuario.Usuario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {
    
    private Usuario usuario;
    
    @BeforeEach
    void setUp() {
        usuario = new Usuario("João Silva", "joao.silva@example.com");
    }
    
    @Test
    @DisplayName("Nome válido com letras e espaços")
    void testNomeValido() {
        assertTrue(usuario.validarNome("João Silva"));
        assertTrue(usuario.validarNome("Maria das Dores"));
        assertTrue(usuario.validarNome("Ana Paula"));
    }
    
    @Test
    @DisplayName("Nome com apóstrofo válido")
    void testNomeComApostrofoValido() {
        assertTrue(usuario.validarNome("D'Avila"));
        assertTrue(usuario.validarNome("O'Reilly"));
    }
    
    @Test
    @DisplayName("Nome não pode ser nulo")
    void testNomeNulo() {
        assertFalse(usuario.validarNome(null));
    }
    
    @Test
    @DisplayName("Nome não pode ser vazio")
    void testNomeVazio() {
        assertFalse(usuario.validarNome(""));
        assertFalse(usuario.validarNome("   "));
    }
    
    @Test
    @DisplayName("Nome não pode conter números")
    void testNomeComNumeros() {
        assertFalse(usuario.validarNome("João123"));
        assertFalse(usuario.validarNome("123 Silva"));
    }
    
    @Test
    @DisplayName("Nome não pode conter caracteres especiais")
    void testNomeComCaracteresEspeciais() {
        assertFalse(usuario.validarNome("João@Silva"));
        assertFalse(usuario.validarNome("Maria-Silva"));
        assertFalse(usuario.validarNome("Ana!Silva"));
        assertFalse(usuario.validarNome("José_Silva"));
    }
    
    @Test
    @DisplayName("Nome não pode começar ou terminar com espaço")
    void testNomeComEspacosExtremos() {
        assertFalse(usuario.validarNome(" João Silva"));
        assertFalse(usuario.validarNome("João Silva "));
        assertFalse(usuario.validarNome("  João Silva  "));
    }
    
    @Test
    @DisplayName("Email válido")
    void testEmailValido() {
        assertTrue(usuario.validarEmail("usuario@dominio.com"));
        assertTrue(usuario.validarEmail("joao.silva@example.com"));
        assertTrue(usuario.validarEmail("maria123@teste.org"));
        assertTrue(usuario.validarEmail("user_name@domain.com"));
        assertTrue(usuario.validarEmail("user-name@domain.com"));
    }
    
    @Test
    @DisplayName("Email não pode ser nulo")
    void testEmailNulo() {
        assertFalse(usuario.validarEmail(null));
    }
    
    @Test
    @DisplayName("Email não pode ser vazio")
    void testEmailVazio() {
        assertFalse(usuario.validarEmail(""));
        assertFalse(usuario.validarEmail("   "));
    }
    
    @Test
    @DisplayName("Email deve conter @")
    void testEmailSemArroba() {
        assertFalse(usuario.validarEmail("usuario.dominio.com"));
        assertFalse(usuario.validarEmail("usuario@"));
        assertFalse(usuario.validarEmail("@dominio.com"));
    }
    
    @Test
    @DisplayName("Email com usuário inválido")
    void testEmailUsuarioInvalido() {
        assertFalse(usuario.validarEmail("usuário@dominio.com")); 
        assertFalse(usuario.validarEmail("user@ção@dominio.com")); 
        assertFalse(usuario.validarEmail("user#@dominio.com")); 
    }
    
    @Test
    @DisplayName("Email com domínio inválido")
    void testEmailDominioInvalido() {
        assertFalse(usuario.validarEmail("user@domínio.com")); 
        assertFalse(usuario.validarEmail("user@domain_.com")); 
        assertFalse(usuario.validarEmail("user@domain..com")); 
    }
    
    @Test
    @DisplayName("Email com múltiplos subdomínios válidos")
    void testEmailMultiplosSubdominios() {
        assertTrue(usuario.validarEmail("user@sub.dominio.com"));
        assertTrue(usuario.validarEmail("user@co.uk"));
        assertTrue(usuario.validarEmail("user@sub.sub2.dominio.com"));
    }
    
    @Test
    @DisplayName("Construtor com dados válidos")
    void testConstrutorValido() {
        Usuario user = new Usuario("Maria Santos", "maria.santos@email.com");
        assertNotNull(user);
        assertEquals("Maria Santos", user.getNome());
        assertEquals("maria.santos@email.com", user.getEmail());
    }
    
    @Test
    @DisplayName("Construtor com nome inválido deve lançar exceção")
    void testConstrutorNomeInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("João123", "joao@email.com");
        });
    }
    
    @Test
    @DisplayName("Construtor com email inválido deve lançar exceção")
    void testConstrutorEmailInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("João Silva", "joao@");
        });
    }
    
    @Test
    @DisplayName("Setter de nome válido")
    void testSetterNomeValido() {
        usuario.setNome("Pedro Alves");
        assertEquals("Pedro Alves", usuario.getNome());
    }
    
    @Test
    @DisplayName("Setter de nome inválido deve lançar exceção")
    void testSetterNomeInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            usuario.setNome("Pedro123");
        });
    }
    
    @Test
    @DisplayName("Setter de email válido")
    void testSetterEmailValido() {
        usuario.setEmail("novo.email@dominio.com");
        assertEquals("novo.email@dominio.com", usuario.getEmail());
    }
    
    @Test
    @DisplayName("Setter de email inválido deve lançar exceção")
    void testSetterEmailInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            usuario.setEmail("email-invalido");
        });
    }
    
    @Test
    @DisplayName("Validar campos com dados válidos")
    void testValidarCamposValidos() {
        assertTrue(usuario.validarCampos());
    }
    
    @Test
    @DisplayName("Validar campos com nome inválido")
    void testValidarCamposNomeInvalido() {
        usuario.setNome("João Silva"); 
        usuario.setNome("João123"); 
        
        Usuario userInvalido = new Usuario("João Silva", "joao@email.com");
      
        try {
            java.lang.reflect.Field field = Usuario.class.getDeclaredField("nome");
            field.setAccessible(true);
            field.set(userInvalido, "João123");
            
            assertFalse(userInvalido.validarCampos());
        } catch (Exception e) {
            fail("Erro no teste de reflexão: " + e.getMessage());
        }
    }
    
    @Test
    @DisplayName("Validar campos com email inválido")
    void testValidarCamposEmailInvalido() {
        Usuario userInvalido = new Usuario("João Silva", "joao@email.com");
        try {
            java.lang.reflect.Field field = Usuario.class.getDeclaredField("email");
            field.setAccessible(true);
            field.set(userInvalido, "email-invalido");
            
            assertFalse(userInvalido.validarCampos());
        } catch (Exception e) {
            fail("Erro no teste de reflexão: " + e.getMessage());
        }
    }
    
    @Test
    @DisplayName("Equals com objetos iguais")
    void testEqualsObjetosIguais() {
        Usuario user1 = new Usuario("João Silva", "joao@email.com");
        Usuario user2 = new Usuario("João Silva", "joao@email.com");
        
        assertEquals(user1, user2);
        assertEquals(user1.hashCode(), user2.hashCode());
    }
    
    @Test
    @DisplayName("Equals com objetos diferentes")
    void testEqualsObjetosDiferentes() {
        Usuario user1 = new Usuario("João Silva", "joao@email.com");
        Usuario user2 = new Usuario("Maria Santos", "maria@email.com");
        
        assertNotEquals(user1, user2);
        assertNotEquals(user1.hashCode(), user2.hashCode());
    }
    
    @Test
    @DisplayName("Equals com null")
    void testEqualsComNull() {
        Usuario user = new Usuario("João Silva", "joao@email.com");
        assertNotEquals(null, user);
    }
    
    @Test
    @DisplayName("ToString retorna representação válida")
    void testToString() {
        Usuario user = new Usuario("João Silva", "joao@email.com");
        String expected = "Usuario{nome='João Silva', email='joao@email.com'}";
        assertEquals(expected, user.toString());
    }
    
    @Test
    @DisplayName("Nome com máximo de palavras")
    void testNomeComMaximoPalavras() {
        assertTrue(usuario.validarNome("João Carlos da Silva Santos Oliveira"));
    }
    
    @Test
    @DisplayName("Email com usuário longo")
    void testEmailUsuarioLongo() {
        assertTrue(usuario.validarEmail("usuario.muito.longo.com.muitos.pontos@dominio.com"));
    }
    
    @Test
    @DisplayName("Email com domínio longo")
    void testEmailDominioLongo() {
        assertTrue(usuario.validarEmail("user@sub.sub2.sub3.sub4.dominio.com"));
    }
    
    @Test
    @DisplayName("Nome com caracteres acentuados válidos")
    void testNomeComAcentos() {
        assertTrue(usuario.validarNome("José Çãõ Éíóú Àèìòù"));
    }
    
    
    @RepeatedTest(5)
    void testAutenticacaoComTentativas(TestInfo testInfo, TestReporter reporter, RepetitionInfo repetitionInfo) {
        Usuario usuario = new Usuario("Luiz", "luiz@email.com");
        usuario.setSenha("senha123");

        try {
            boolean resultado = usuario.autenticar("senhaErrada");
            reporter.publishEntry("Tentativa " + repetitionInfo.getCurrentRepetition() + ": " + resultado);
        } catch (ExceededAttemptsException e) {
            reporter.publishEntry("Tentativa bloqueada: " + e.getMessage());
        }
    }

    
}
