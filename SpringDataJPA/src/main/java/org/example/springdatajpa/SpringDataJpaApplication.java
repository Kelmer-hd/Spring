package org.example.springdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpaApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
        CocheRepository repository = context.getBean(CocheRepository.class);

        System.out.println("find");
        System.out.println("El num de coches en base de datos es " +repository.count());

        // Crear y almacenar un coche en la base de datos
        Coche toyota = new Coche(null, "Toyata", "Prius", 2019);
        repository.save(toyota);
        System.out.println("El num de coches en base de datos es " +repository.count());

        System.out.println(repository.findAll());
    }



}
