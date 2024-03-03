package org.example.springdatajpa_ejercicio_01;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositoty extends JpaRepository<Producto, Long> {

}
