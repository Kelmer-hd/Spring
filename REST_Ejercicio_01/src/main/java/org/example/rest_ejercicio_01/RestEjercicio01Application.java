package org.example.rest_ejercicio_01;
import org.example.rest_ejercicio_01.entity.Tarea;
import org.example.rest_ejercicio_01.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class RestEjercicio01Application implements CommandLineRunner {

    @Autowired
    TareaRepository tareaRepository;
    public static void main(String[] args) {
        SpringApplication.run(RestEjercicio01Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Tarea tarea1 = new Tarea(null, "Aprender Spring Boot", "Aprender Spring Boot Application", false, LocalDate.now());
        tareaRepository.save(tarea1);
    }
}
