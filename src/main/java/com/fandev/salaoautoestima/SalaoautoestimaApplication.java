package com.fandev.salaoautoestima;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fandev.salaoautoestima.domain.Estado;
import com.fandev.salaoautoestima.repositories.EstadoRepository;

@SpringBootApplication
public class SalaoautoestimaApplication implements CommandLineRunner {
	
	@Autowired
	private EstadoRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SalaoautoestimaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estado e1 = new Estado(null,"Minas Gerais");
		Estado e2 = new Estado(null,"Bahia");
		
		repo.saveAll(Arrays.asList(e1, e2)); //Adiciona os objetos em uma lista definida no Arrays.asList e salva todos os objetos de uma vez no banco de dados
		
	}

}
