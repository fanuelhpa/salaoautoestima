package com.fandev.salaoautoestima;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fandev.salaoautoestima.domain.Cidade;
import com.fandev.salaoautoestima.domain.Endereco;
import com.fandev.salaoautoestima.domain.Estado;
import com.fandev.salaoautoestima.domain.HorarioProcedimento;
import com.fandev.salaoautoestima.domain.Procedimento;
import com.fandev.salaoautoestima.domain.Produto;
import com.fandev.salaoautoestima.domain.Usuario;
import com.fandev.salaoautoestima.domain.enums.TipoUsuario;
import com.fandev.salaoautoestima.repositories.CidadeRepository;
import com.fandev.salaoautoestima.repositories.EnderecoRepository;
import com.fandev.salaoautoestima.repositories.EstadoRepository;
import com.fandev.salaoautoestima.repositories.HorarioProcedimentoRepository;
import com.fandev.salaoautoestima.repositories.ProcedimentoRepository;
import com.fandev.salaoautoestima.repositories.ProdutoRepository;
import com.fandev.salaoautoestima.repositories.UsuarioRepository;

@SpringBootApplication
public class SalaoautoestimaApplication implements CommandLineRunner {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	
	@Autowired
	private HorarioProcedimentoRepository horarioProcedimentoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SalaoautoestimaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estado e1 = new Estado(null,"Minas Gerais");
		Estado e2 = new Estado(null,"Bahia");
		
		//Todas as cidades conhecem seus estados
		Cidade ci1 = new Cidade(null, "Ribeirão das Neves",e1);
		Cidade ci2 = new Cidade(null, "Salvador", e2);
		Cidade ci3 = new Cidade(null, "Ouro Preto", e1);
		
		//Associando as cidades aos seus respectivos estados 
		e1.getCidades().addAll(Arrays.asList(ci1,ci3));
		e2.getCidades().add(ci2);
		
		//Adiciona os objetos em uma lista definida no Arrays.asList e salva todos os objetos de uma vez no banco de dados
		estadoRepository.saveAll(Arrays.asList(e1, e2));
		cidadeRepository.saveAll(Arrays.asList(ci1, ci2, ci3));
		
		//Instancias de usuarios, telefones e endereços
		Usuario user1 = new Usuario(null, "Fanuel Pereira", "Fanuel123@","fanuel@gmail.com", TipoUsuario.ADMINISTRADOR);
		Usuario user2 = new Usuario(null,"Aline Dias", "Aline123@", "aline@gmail.com", TipoUsuario.CLIENTE);
		Usuario user3 = new Usuario(null, "Pedro Alves", "Pedro123@", "pedro@gmail.com", TipoUsuario.CLIENTE);
		Usuario user4 = new Usuario(null, "Marly Santos", "Marly123@", "marly@gmail.com", TipoUsuario.ADMINISTRADOR);
		Usuario user5 = new Usuario(null,"Kesia Emanuela", "Kesia123@", "kesia@gmail.com",TipoUsuario.CLIENTE);
		
		user1.getTelefones().addAll(Arrays.asList("313456-2402", "3199247-6569"));
		user2.getTelefones().addAll(Arrays.asList("313551-7660"));
		user3.getTelefones().addAll(Arrays.asList("4499778-4433", "4495588-4400"));
		user4.getTelefones().addAll(Arrays.asList("3199882288"));
		user5.getTelefones().add("3193388-4455");
		
		Endereco en1 = new Endereco(null, "Rua Antonio Zacarias do Anjos", "410", "Casa", "Jardim Primavera", "33933-660", ci1);
		Endereco en2 = new Endereco(null,"Rua Bahia","24","casa","Oliveira","44867-796", ci2);
		Endereco en3 = new Endereco(null, "Rua Antonio Jose Ramos", "180", "Casa", "Bauxita","35400-000", ci3);
		
		user1.getEnderecos().addAll(Arrays.asList(en1, en3));
		user2.getEnderecos().add(en3);
		user3.getEnderecos().add(en2);
		user4.getEnderecos().add(en1);
		user5.getEnderecos().add(en1);
		
		en1.getUsuarios().addAll(Arrays.asList(user1, user4, user5));
		en2.getUsuarios().addAll(Arrays.asList(user3));
		en3.getUsuarios().addAll(Arrays.asList(user1, user2));
		
		enderecoRepository.saveAll(Arrays.asList(en1, en2, en3));
		usuarioRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5));
		
		//Instancias de procedimentos e horarios de procedimentos
		
		//Objeto SimpleDateFormat para formatação das datas
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Procedimento p1 = new Procedimento(null, "Corte", 10.00);
		Procedimento p2 = new Procedimento(null, "Escova", 20.00);
		Procedimento p3 = new Procedimento(null, "Pintura", 50.00);
		
		HorarioProcedimento hp1 = new HorarioProcedimento(user1, p1, sdf1.parse("16/07/2022 10:30"), 2.00);
		HorarioProcedimento hp2 = new HorarioProcedimento(user5, p2, sdf1.parse("13/07/2022 9:30"), 3.00);
		HorarioProcedimento hp3 = new HorarioProcedimento(user2, p2, sdf1.parse("20/07/2022 14:20"), 0.00);
		HorarioProcedimento hp4 = new HorarioProcedimento(user3, p1, sdf1.parse("27/05/2022 17:00"), 0.00);
		HorarioProcedimento hp5 = new HorarioProcedimento(user2, p3, sdf1.parse("18/08/2022 9:30"), 3.00);
		
		//Associação entre usuario e procedimento
		user1.getProcedimentos().add(p1);
		user2.getProcedimentos().addAll(Arrays.asList(p2,p3));
		user3.getProcedimentos().add(p1);
		user5.getProcedimentos().add(p2);
		
		p1.getUsuarios().addAll(Arrays.asList(user1,user3));
		p2.getUsuarios().addAll(Arrays.asList(user5, user2));
		p3.getUsuarios().add(user2);
		
		procedimentoRepository.saveAll(Arrays.asList(p1, p2, p3));
		horarioProcedimentoRepository.saveAll(Arrays.asList(hp1, hp2, hp3, hp4, hp5));
		
		//Intancias de produtos
		
		Produto prod1 = new Produto(null, "Shampoo Hair Strong", 20.00, 5, user4);
		Produto prod2 = new Produto(null, "Relaxante Hair-Life", 15.00, 2, user4);
		Produto prod3 = new Produto(null, "Creme Meu Cabelo", 25.00, 7, user1);
		
		user1.getProdutos().addAll(Arrays.asList(prod1));
		user4.getProdutos().addAll(Arrays.asList(prod1, prod2));
		 
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		 
	}
}
