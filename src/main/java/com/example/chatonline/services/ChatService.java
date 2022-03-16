package com.example.chatonline.services;

import com.example.chatonline.domain.Mensagem;
import com.example.chatonline.domain.Usuario;
import com.example.chatonline.repositories.ChatRepository;
import com.example.chatonline.repositories.MensagemRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    private MensagemRepository mensagemRepository;

    public List<Mensagem> findMessages(){
        return mensagemRepository.findAll();
    }

    public Mensagem findMessage(Integer id){
        Optional<Mensagem> obj = mensagemRepository.findById(id);
        return obj.orElseThrow(() ->  new ObjectNotFoundException(1, "Não encontrado"));
    }

    public Mensagem insertMessage(Mensagem obj){
       return mensagemRepository.save(obj);
    }

    public void deleteMessage(Integer id){
        Mensagem msg = this.findMessage(id);
        if (msg == null)
            throw new ObjectNotFoundException(1, "Não encontrado");

        mensagemRepository.deleteById(id);
    }
}
