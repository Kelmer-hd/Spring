package org.example.springbootrestdatajpa.services;

import org.example.springbootrestdatajpa.entity.Book;

public class BookPriceCalculator {

    public double calculatePrice(Book book){
        double price = book.getPrice();

        if (book.getPages() > 1000){
            price += 5;
        }

        // Envio
        price += 2.99;
        return price;
    }
}
