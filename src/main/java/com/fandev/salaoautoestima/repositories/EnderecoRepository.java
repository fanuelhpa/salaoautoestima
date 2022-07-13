package com.fandev.salaoautoestima.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fandev.salaoautoestima.domain.Endereco;

@Repository //Responsável pelas operações do banco de dados
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}