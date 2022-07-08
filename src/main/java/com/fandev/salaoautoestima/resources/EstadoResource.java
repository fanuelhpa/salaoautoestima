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

@RestController //anotação que define a classe como controlador Rest
@RequestMapping(value="/estados") //anotação que mapeia o valor "estados" para o controlador Rest. Este valor será utilizado pela aplicação cliente.
public class EstadoResource {
	
	//anotação que cria automaticamente uma instancia para "service", dependencia de EstadoService
	@Autowired
	private EstadoService service;

	//anotação que define que o metodo buscar() será acessado com a especificação de um id. Ao ser passado o id, o programa programa executa o metodo buscar, recebendo o id informado.
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) { //PathVariable indica que o id passado na url será atribuido ao id argumento do método
		
		Estado obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);	
	}	
}
