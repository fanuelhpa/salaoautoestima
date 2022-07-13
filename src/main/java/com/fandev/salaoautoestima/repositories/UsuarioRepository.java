package com.fandev.salaoautoestima.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fandev.salaoautoestima.domain.Usuario;

@Repository //Responsável pelas operações do banco de dados
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}