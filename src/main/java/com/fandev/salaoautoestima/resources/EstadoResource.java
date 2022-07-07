package com.fandev.salaoautoestima.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fandev.salaoautoestima.domain.Estado;

@RestController
@RequestMapping(value="/estados")
public class EstadoResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Estado> listar() {
		
		Estado estado1 = new Estado(1, "Minas Gerais");
		Estado estado2 = new Estado(2, "Bahia");
		
		List<Estado> lista = new ArrayList<>();
		lista.add(estado1);
		lista.add(estado2);
		
		return lista;
		
	}	
}
