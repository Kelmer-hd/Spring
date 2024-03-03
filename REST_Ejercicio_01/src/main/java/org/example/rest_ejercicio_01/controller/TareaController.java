package org.example.rest_ejercicio_01.controller;
import org.example.rest_ejercicio_01.entity.Tarea;
import org.example.rest_ejercicio_01.repository.TareaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TareaController {

    TareaRepository tareaRepository;

    public TareaController(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    // Crud

    // Listar todas las tareas
    @GetMapping("api/tarea")
    public List<Tarea> findAll(){
       return tareaRepository.findAll();
    }

    // Listar tarea por su Id
    @GetMapping("/api/tarea/{id}")
    public ResponseEntity<Tarea> findOneById(@PathVariable Long id){
        Optional<Tarea> tareaOption = tareaRepository.findById(id);
        if (tareaOption.isPresent()){
            return ResponseEntity.ok(tareaOption.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/tarea")
    public Tarea create(@RequestBody Tarea tarea){
        return tareaRepository.save(tarea);
    }

    @PutMapping("api/tarea/{id}")
    public Tarea actualizarTarea(@PathVariable Long id, @RequestBody Tarea tareaActualizada) {
        Tarea tareaExistente = tareaRepository.findById(id).orElse(null);
        if (tareaExistente != null) {
            tareaExistente.setTitulo(tareaActualizada.getTitulo());
            tareaExistente.setDescripcion(tareaActualizada.getDescripcion());
            tareaExistente.setCompletada(tareaActualizada.getCompletada());
            return tareaRepository.save(tareaExistente);
        } else {
            return null;
        }
    }

    @DeleteMapping("api/tarea/{id}")
    public void eliminarTarea(@PathVariable Long id) {
        tareaRepository.deleteById(id);
    }
}
