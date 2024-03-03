package org.example.springbootrestdatajpa.repository;
import org.example.springbootrestdatajpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Infica el Repostitorio
public interface BookRepository extends JpaRepository<Book, Long> {
}
