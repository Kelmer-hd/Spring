package org.example.springbootrestdatajpa.controller;
import org.example.springbootrestdatajpa.entity.Book;
import org.example.springbootrestdatajpa.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);
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
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        // Guardar el libro recibido por parametro en la BD
        if (book.getId()!= null){
            log.warn("tryping to create a book with id");
            return ResponseEntity.badRequest().build();
        }
        if (!bookRepository.existsById(book.getId())){
            log.warn("Tryping to update a non existent book");
            return ResponseEntity.notFound().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }
    // Actualizar un libro en la base de datos

    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
        if (book.getId() == null){
            log.warn("Tryping to update a non exitent book");
            return  ResponseEntity.badRequest().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }

    // borrar un libro en la base de datos
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){

        if (!bookRepository.existsById(id)){
            log.warn("Tryping to delete a non exitent book");
            return  ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteApp(){
        log.info("REST Deleting all books");
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
