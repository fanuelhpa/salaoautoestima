package com.fandev.salaoautoestima;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fandev.salaoautoestima.domain.Cidade;
import com.fandev.salaoautoestima.domain.Estado;
import com.fandev.salaoautoestima.repositories.CidadeRepository;
import com.fandev.salaoautoestima.repositories.EstadoRepository;

@SpringBootApplication
public class SalaoautoestimaApplication implements CommandLineRunner {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SalaoautoestimaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estado e1 = new Estado(null,"Minas Gerais");
		Estado e2 = new Estado(null,"Bahia");
		
		//Todas as cidades conhecem seus estados
		Cidade ci1 = new Cidade(null, "Belo Horizonte",e1);
		Cidade ci2 = new Cidade(null, "Salvador", e2);
		Cidade ci3 = new Cidade(null, "Ouro Preto", e1);
		
		//Associando as cidades aos seus respectivos estados 
		e1.getCidades().addAll(Arrays.asList(ci1,ci3));
		e2.getCidades().add(ci2);
		
		//Adiciona os objetos em uma lista definida no Arrays.asList e salva todos os objetos de uma vez no banco de dados
		estadoRepository.saveAll(Arrays.asList(e1, e2));
		cidadeRepository.saveAll(Arrays.asList(ci1, ci2, ci3));
	}
}
