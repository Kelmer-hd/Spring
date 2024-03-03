package org.example.rest_ejercicio_01.repository;
import org.example.rest_ejercicio_01.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea,Long> {
}
