package org.example.springbootrestdatajpa.controller;
import org.example.springbootrestdatajpa.entity.Book;
import org.example.springbootrestdatajpa.repository.BookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    // Atrributos
    private BookRepository bookRepository;
    // Constructores

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CRUD sobre la entidad Book

    // Buscar todos los libros (Lista de libros)
    @GetMapping("/api/books")
    public List<Book> findAll(){
        // Recuperar y devolver los libros de la base de datos
        return bookRepository.findAll();
    }

    // Buscar un solo libro en base de datos segun si id
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id){
        Optional<Book> bookOption = bookRepository.findById(id);
        // Opcion 1
            if (bookOption.isPresent()){
                return ResponseEntity.ok(bookOption.get());
            }else{
                return ResponseEntity.notFound().build();
            }

        // Opcion 2
            //return bookOption.orElse(null);
    }
    // Crear un nuevo libro en la base de datos

    @PostMapping("/api/books")
    public Book create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        // Guardar el libro recibido por parametro en la BD
        return bookRepository.save(book);
    }
    // Actualizar un libro en la base de datos

    // borrar un libro en la base de datos

}
