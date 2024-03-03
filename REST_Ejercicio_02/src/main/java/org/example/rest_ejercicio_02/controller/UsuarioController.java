package org.example.rest_ejercicio_02.controller;
import org.example.rest_ejercicio_02.entity.Usuario;
import org.example.rest_ejercicio_02.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> UsuarioID(@PathVariable Long id){
        Optional<Usuario> usuarioExiste = usuarioRepository.findById(id);
        if(usuarioExiste.isPresent()){
            return ResponseEntity.ok(usuarioExiste.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/usuarios")
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }


    @PutMapping("usuario/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setEmail(usuarioActualizado.getEmail());
            usuarioExistente.setEdad(usuarioActualizado.getEdad());
            return usuarioRepository.save(usuarioExistente);
        } else {
            return null;
        }
    }

    @DeleteMapping("usuario/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }


}
