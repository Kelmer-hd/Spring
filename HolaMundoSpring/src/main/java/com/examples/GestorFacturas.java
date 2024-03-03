package com.examples;

import java.sql.SQLOutput;

public class GestorFacturas {

    CalculatorServices calculatorServices;
    String nombre;
    // Constructor
    public GestorFacturas(CalculatorServices calculatorServices, String nombre){
        System.out.println("Ejecutando Constructor GestionFactura");
        this.calculatorServices = calculatorServices;
        this.nombre = nombre;
    }
}
