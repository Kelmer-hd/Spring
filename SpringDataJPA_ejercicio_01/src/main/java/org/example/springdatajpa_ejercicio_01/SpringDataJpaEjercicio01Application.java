package org.example.springdatajpa_ejercicio_01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaEjercicio01Application implements CommandLineRunner{


    @Autowired
    private ProductoRepositoty productoRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaEjercicio01Application.class, args);


    }

    public void run(String...args) throws Exception {
        // Crear y guardar algunos productos
        Producto producto1 = new Producto("Camiseta", 19.99, 100);
        Producto producto2 = new Producto("Pantalones", 29.99, 50);
        productoRepository.save(producto1);
        productoRepository.save(producto2);

        Producto productoRecuperado = productoRepository.findById(2L).orElse(null);
        if (productoRecuperado != null) {
            System.out.println("Producto encontrado: " + productoRecuperado.getNombre());
        } else {
            System.out.println("Producto no encontrado");
        }

        // Mostrar todos los productos en la base de datos
        System.out.println("Todos los productos:");
        productoRepository.findAll().forEach(producto -> System.out.println(producto.getNombre()));
    }

}

