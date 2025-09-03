/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author luizh
 */

public class HelloJUnitTest {
    /*
    public HelloJUnitTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    \*/
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     
    @Test
    @DisplayName("Diz oi pf")
    public void hello() {
        assertEquals("Hello, World of Tests!", Hello.sayHello());
    }
     
    @Test 
    @Disabled
    public void calcular(){
        assertEquals(2.0+2.0, Calculator.somar(2.0, 2.0));
        assertEquals(2.0/1, Calculator.divisao(2.0, 1));
    }
}
