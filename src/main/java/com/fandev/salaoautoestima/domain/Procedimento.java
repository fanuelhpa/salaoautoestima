package com.fandev.salaoautoestima.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Procedimento implements Serializable {
	private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY )
		private Integer id;
		private String nome;
		private Double preco;
		
		@JsonIgnore
		@OneToMany(mappedBy = "id.procedimento")
		private Set<HorarioProcedimento> horariosProcedimentos = new HashSet<>();
		
		public Procedimento(){
			
		}

		public Procedimento(Integer id, String nome, Double preco) {
			super();
			this.id = id;
			this.nome = nome;
			this.preco = preco;
		}
		
		@JsonIgnore
		public List<Usuario> getUsuarios(){
			
			List<Usuario> usuarios = new ArrayList<>();
			
			for (HorarioProcedimento x : horariosProcedimentos) {
				
				usuarios.add(x.getUsuario());
			}
			
			return usuarios;
		} 
	
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Double getPreco() {
			return preco;
		}

		public void setPreco(Double preco) {
			this.preco = preco;
		}

		public Set<HorarioProcedimento> getHorariosProcedimentos() {
			return horariosProcedimentos;
		}

		public void setHorariosProcedimentos(Set<HorarioProcedimento> horariosProcedimentos) {
			this.horariosProcedimentos = horariosProcedimentos;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Procedimento other = (Procedimento) obj;
			return Objects.equals(id, other.id);
		}
		
}
