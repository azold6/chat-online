package com.example.chatonline.controllers;


import com.example.chatonline.domain.Usuario;
import com.example.chatonline.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> usuarios = usuarioService.findAll();

        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id){
        Usuario usuario = usuarioService.findById(id);

        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Usuario obj){
        obj = usuarioService.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
