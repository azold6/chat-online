package com.example.chatonline.controllers;

import com.example.chatonline.domain.Mensagem;
import com.example.chatonline.domain.Usuario;
import com.example.chatonline.services.ChatService;
import com.example.chatonline.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/chat")
public class ChatController {

    @Autowired
    private ChatService service;

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/usuarios")
    public ResponseEntity<List<Usuario>> findOnlineUsers(){
        List<Usuario> usuarios = usuarioService.findByOnlineUsers();

        return ResponseEntity.ok().body(usuarios);
    }

    @RequestMapping(value = "/mensagens")
    public ResponseEntity<List<Mensagem>> findMessages(){
        List<Mensagem> obj = service.findMessages();
        return ResponseEntity.ok().body(obj);
    }


}
