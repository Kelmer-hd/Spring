package org.example.springbootrestdatajpa.services;

import org.example.springbootrestdatajpa.entity.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void calculatePrice() {
        // Configuracion de la prueba
        Book book = new Book(1L, "El señor de los Anillo", "kelmer", 1000, 49.90, LocalDate.now(), true);
        BookPriceCalculator calculator = new BookPriceCalculator();

        // Se ejecuta el comportamiento a testear
        double price = calculator.calculatePrice(book);

        //Comprobaciones de que todo esta bien
        System.out.println(price);
        assertTrue(price > 0);
        assertEquals(52.89, price);

    }
}