package org.example.springdatajpa_ejercicio_02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaEjercicio02Application implements CommandLineRunner {

    @Autowired
    ProductoRepository productoRepository;
    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaEjercicio02Application.class, args);
    }

    public void run(String[] args){
        Producto producto1 = new Producto("Camisa", 90.0, 5);
        Producto producto2 = new Producto("Pantalon", 120.99, 10);
        productoRepository.save(producto1);  // Guardando el producto en la BD
        productoRepository.save(producto2);

        // Recuperar Todos los productos

        productoRepository.findAll().forEach(producto -> System.out.println(producto.getNombre()));


        Producto productoRecuperado = productoRepository.findById(1L).orElse(null);
        if (productoRecuperado != null) {
            productoRecuperado.setPrecio(24.99);
            productoRepository.save(productoRecuperado);
            System.out.println("Precio actualizado para " + productoRecuperado.getNombre());
        } else {
            System.out.println("Producto no encontrado");
        }

        // Eliminar un producto de la base de datos
        productoRepository.deleteById(2L);
        System.out.println("Producto eliminado");

        // Mostrar todos los productos actualizados en la base de datos
        System.out.println("Todos los productos actualizados:");
        productoRepository.findAll().forEach(producto -> System.out.println(producto.getNombre()));
    }
}



