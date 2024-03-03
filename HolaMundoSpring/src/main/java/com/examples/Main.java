package com.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // crear un objeto de forma normal
        CalculatorServices services = new CalculatorServices();


        // Opción 2: Recibir un objeto de Spring
        CalculatorServices calculadora = (CalculatorServices)context.getBean("calculatorServices");
        String texto = calculadora.holaMundo();
        System.out.println(texto);

        CalculatorServices calculadora2 = (CalculatorServices)context.getBean("calculatorServices");
        texto = calculadora.holaMundo();
        System.out.println(texto);


        // EJEMPLO 2

        GestorFacturas gestor = (GestorFacturas)context.getBean("gestorFacturas");
        System.out.println(gestor.calculatorServices.holaMundo());

    }
}
