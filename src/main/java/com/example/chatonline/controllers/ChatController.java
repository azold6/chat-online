package com.example.chatonline.controllers;

import com.example.chatonline.domain.Mensagem;
import com.example.chatonline.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/chat")
public class ChatController {

    @Autowired
    private ChatService service;

    @RequestMapping(value = "/mensagens")
    public ResponseEntity<List<Mensagem>> findMessages(){
        List<Mensagem> obj = service.findMessages();
        return ResponseEntity.ok().body(obj);
    }
}
