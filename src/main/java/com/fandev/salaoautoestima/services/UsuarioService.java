package com.fandev.salaoautoestima.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fandev.salaoautoestima.domain.Usuario;
import com.fandev.salaoautoestima.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	public Usuario buscar(Integer id) {
		
		Optional<Usuario> usuario = repo.findById(id);
		return usuario.orElse(null);

	}
}
