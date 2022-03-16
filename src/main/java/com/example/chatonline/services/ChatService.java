package com.example.chatonline.services;

import com.example.chatonline.domain.Mensagem;
import com.example.chatonline.repositories.ChatRepository;
import com.example.chatonline.repositories.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    private MensagemRepository repo;

    public List<Mensagem> findMessages(){
        return repo.findAll();
    }
}
