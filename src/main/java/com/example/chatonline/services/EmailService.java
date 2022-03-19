package com.example.chatonline.services;

import com.example.chatonline.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${default.sender}")
    private String sender;

    @Autowired
    private MailSender mailSender;

    public void sendEmail(Usuario usuario){
        SimpleMailMessage message = prepareSimpleMailMessageFromUsuario(usuario);
        mailSender.send(message);
    }

    public SimpleMailMessage prepareSimpleMailMessageFromUsuario(Usuario usuario){
        SimpleMailMessage sm = new SimpleMailMessage();

        sm.setFrom(sender);
        sm.setTo(usuario.getEmail());
        sm.setSubject("Sua conta foi criada com sucesso!");
        sm.setText("Olá " + usuario.getNome() +"! Informamos que você já tem acesso ao chat de mensagens :)");

        return sm;
    }
}