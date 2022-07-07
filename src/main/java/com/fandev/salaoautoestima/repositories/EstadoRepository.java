package com.fandev.salaoautoestima.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fandev.salaoautoestima.domain.Estado;

@Repository //Responsável pelas operações do banco de dados
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}