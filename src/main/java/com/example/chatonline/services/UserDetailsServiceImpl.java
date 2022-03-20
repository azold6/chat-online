package com.example.chatonline.services;

import com.example.chatonline.domain.Usuario;
import com.example.chatonline.repositories.UsuarioRepository;
import com.example.chatonline.security.UserSS;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> obj = repo.findByEmail(email);
        if (obj.isEmpty()) throw new ObjectNotFoundException(1, "Não encontrado");
        return new UserSS(obj.get().getId(), obj.get().getEmail(), obj.get().getSenha(), obj.get().getPerfis());
    }
}
