package com.fandev.salaoautoestima.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fandev.salaoautoestima.domain.HorarioProcedimento;

@Repository //Responsável pelas operações do banco de dados
public interface HorarioProcedimentoRepository extends JpaRepository<HorarioProcedimento, Integer> {

}