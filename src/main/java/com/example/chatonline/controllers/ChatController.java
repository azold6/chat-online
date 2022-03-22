package com.example.chatonline.controllers;

import com.example.chatonline.domain.Mensagem;
import com.example.chatonline.domain.Usuario;
import com.example.chatonline.services.ChatService;
import com.example.chatonline.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    UsuarioService usuarioService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/usuarios")
    public ResponseEntity<List<Usuario>> findOnlineUsers(){
        List<Usuario> usuarios = usuarioService.findByOnlineUsers();

        return ResponseEntity.ok().body(usuarios);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/mensagens")
    public ResponseEntity<List<Mensagem>> findMessages(){
        List<Mensagem> obj = chatService.findMessages();
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> insertMessage(@RequestBody Mensagem obj){
        obj = chatService.insertMessage(obj);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/mensagens/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteMessage(@PathVariable Integer id){
        chatService.deleteMessage(id);

        return ResponseEntity.noContent().build();
    }
}
