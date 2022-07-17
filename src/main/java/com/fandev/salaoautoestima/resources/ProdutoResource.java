package com.fandev.salaoautoestima.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fandev.salaoautoestima.domain.Produto;
import com.fandev.salaoautoestima.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id){
		
		Produto produto = service.buscar(id);
		return ResponseEntity.ok().body(produto);
	}
}
