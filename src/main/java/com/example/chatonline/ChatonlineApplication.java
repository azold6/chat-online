package com.example.chatonline;

import com.example.chatonline.domain.Mensagem;
import com.example.chatonline.domain.Usuario;
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

		Usuario user1 = new Usuario(null, "Alex", "alex@gmal.com", "123");
		Mensagem msg1 = new Mensagem(null, "Oi, tudo bom?", new Date(2022, 03, 15), user1);

		usuarioRepository.saveAll(Arrays.asList(user1));
		mensagemRepository.saveAll(Arrays.asList(msg1));
	}
}
