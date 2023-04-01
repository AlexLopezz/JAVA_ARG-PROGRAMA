package org.alexdev;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {
    //Variables globales:
    Calculadora calculadora;
    // Variables de entrada:
    // Dos variables para los las distintas operaciones(unNumero, otroNumero)
    double unNumero;
    double otroNumero;
    //Una variable auxiliar para realizar operaciones.
    double aux;
    //Una variable para almacenar los distintos resultados de los test.
    double resultado;
    //Por ultimo una variable que nos servira para identificar el resultado esperado de la operacion.
    double resultadoEsperado;
    //Una variable String para almacenar el nombre del metodo de cada test.
    String methodName;

    @BeforeAll
    static void beforeAll(){ System.out.println("----- Inicializando pruebas Test a clase Calculadora ----"); }

    @AfterAll
    static void afterAll() { System.out.println("----- Pruebas a clase Calculadora finalizada -----"); }
    @BeforeEach //Se ejecutara antes de cada test.
    void initTest(){
        this.calculadora = new Calculadora();
    }
    @AfterEach
    void finalizeTest(){
        System.out.println("Resultado final: "+resultado);
        unNumero = 0;
        otroNumero = 0;
        aux = 0;
        resultado= 0;
        resultadoEsperado = 0;
    }


    @Test
    @DisplayName("Resultado de multiplicar 80 por 3, da 240") //a) El resultado de multiplicar 80 por 3, da 240.
    void testMultiplicar(){
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName(); //Obtenemos el nombre de cada metodo de la siguiente manera.
        //Variables de entradas:
        unNumero = 80;
        otroNumero = 3;
        resultadoEsperado = 240;

        resultado = calculadora.multiplicar(unNumero, otroNumero);

        assertEquals(resultado,resultadoEsperado, () -> "Se esperaba como resultado de la operacion: 240.");
        finalizeTest(methodName);
    }

    @Test
    @DisplayName("Resultado de sumar 150 y 180 por 3, da 110")
    void testSumaDivision(){
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //Variables de entradas:
        unNumero = 150;
        otroNumero = 180;
        aux = 3;
        resultadoEsperado = 110;

        resultado = calculadora.sumar(unNumero, otroNumero);
        resultado = calculadora.dividir(resultado, aux);

        assertEquals(resultado, resultadoEsperado, () -> "Se esperaba como resultado de la operacion: 110.");
        finalizeTest(methodName);
    }

    @Test
    @DisplayName("Resultado de restar 90 y 50, multiplicado por 15, NO da 605")
    void testRestaMultiplicacion(){
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //Variables de entradas:
        unNumero = 90;
        otroNumero= 50;
        aux = 15;
        resultadoEsperado = 605;

        resultado= calculadora.restar(unNumero, otroNumero);
        resultado= calculadora.multiplicar(resultado, aux);

        assertTrue(resultado != resultadoEsperado);
        finalizeTest(methodName);
    }

    @Test
    @DisplayName("Resultado de sumar 70 y 40, multiplicado por 25 no da 2700")
    void testSumaMultiplicacion(){
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //Variables de entrada:
        double num = 70;
        double num2 = 40;
        double num3 = 25;
        double resultadoEsperado = 2700;

        resultado = calculadora.sumar(num,num2);
        resultado = calculadora.multiplicar(resultado, num3);

        assertTrue(resultado != resultadoEsperado);
        finalizeTest(methodName);
    }

    private void finalizeTest(String methodName){
        System.out.print("Prueba finalizada en el test -> "+methodName+"(): ");
    }
}
