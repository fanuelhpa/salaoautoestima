package com.fandev.salaoautoestima.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fandev.salaoautoestima.domain.Estado;
import com.fandev.salaoautoestima.services.EstadoService;

//Objeto que envia a resposta http à alguma aplicação que fez a requisição.
//Ele delega ao serviço o que deve ser feito dependendo da requisição.
//O serviço por sua vez acesso o repository, que devolve o que deve ser 
//enviado para a aplicação por este objeto.

@RestController
@RequestMapping(value="/estados")
public class EstadoResource {
	
	@Autowired
	private EstadoService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		
		Estado obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);	
	}	
}
