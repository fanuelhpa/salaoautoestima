package com.fandev.salaoautoestima.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fandev.salaoautoestima.domain.Estado;
import com.fandev.salaoautoestima.repositories.EstadoRepository;

/*Objeto reponsável por buscar no repositorio o que foi passado no controle 
e devolver a resposta do repositorio ao controller*/

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repo;
		
	public Estado buscar(Integer id) {
		
		Optional<Estado> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
