package com.fandev.salaoautoestima.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fandev.salaoautoestima.domain.Produto;
import com.fandev.salaoautoestima.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
	public Produto buscar(Integer id) {
		
		Optional<Produto> produto = repo.findById(id);
		return produto.orElse(null);

	}
	
	
}
