package com.example.chatonline;

import com.example.chatonline.domain.Mensagem;
import com.example.chatonline.domain.Usuario;
import com.example.chatonline.domain.enums.Status;
import com.example.chatonline.repositories.MensagemRepository;
import com.example.chatonline.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;


@SpringBootApplication
public class ChatonlineApplication implements CommandLineRunner {

	@Autowired
	private MensagemRepository mensagemRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(ChatonlineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario user1 = new Usuario(null, "Alex", "alex@gmail.com", "123");
		Usuario user2 = new Usuario(null, "Bruna", "bruna@gmail.com", "123", Status.ONLINE);
		Usuario user3 = new Usuario(null, "Maria", "maria@gmail.com", "123", Status.ONLINE);

		Mensagem msg1 = new Mensagem(null, "Oi, tudo bom?", new Date(2022, 03, 15), user1);
		Mensagem msg2 = new Mensagem(null, "Tudo bem e com você?", new Date(2022, 03, 15), user2);
		Mensagem msg3 = new Mensagem(null, "Olá, pessoal!", new Date(2022, 03, 15), user3);

		usuarioRepository.saveAll(Arrays.asList(user1, user2, user3));
		mensagemRepository.saveAll(Arrays.asList(msg1, msg2, msg3));
	}
}
