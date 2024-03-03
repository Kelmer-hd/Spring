package org.example.springbootrestdatajpa;
import org.example.springbootrestdatajpa.entity.Book;
import org.example.springbootrestdatajpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SpringBootRestDataJpaApplication implements CommandLineRunner {

    @Autowired // Inyección del repositorio BookRepository
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestDataJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Crear libros
        Book book1 = new Book(null, "Aprendiendo a programar", "Kelmer Hernández", 450, 20.90, LocalDate.of(2018, 12, 1), true);
        Book book2 = new Book(null, "Aprendiendo a programar en Java", "Kelmer Hernández", 450, 20.90, LocalDate.of(2018, 12, 23), true);
        Book book3 = new Book(null, "Aprendiendo a programar en JavaScript", "Kelmer Hernández", 450, 20.90, LocalDate.of(2018, 12, 23), false);

        // Almacenar libros en la base de datos
        System.out.println("Número de libros en la base de datos antes de guardar: " + bookRepository.count());
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        // Recuperar todos los libros de la base de datos
        System.out.println("Número de libros en la base de datos después de guardar: " + bookRepository.count());

        // Borrar un libro
        //bookRepository.deleteById(1L);
        System.out.println("Número de libros en la base de datos después de eliminar: " + bookRepository.count());
    }
}
