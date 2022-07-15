package com.fandev.salaoautoestima.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fandev.salaoautoestima.domain.enums.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String senha;
	private String email;
	private TipoUsuario tipoUsuario;
	
	@ElementCollection
	@CollectionTable(name="TELEFONE")
	private Set<String> telefones = new HashSet<>();
	
	@JsonManagedReference
	@ManyToMany
	@JoinTable(name = "USUARIO_ENDERECO",
		joinColumns = @JoinColumn(name = "usuario_id"),
		inverseJoinColumns = @JoinColumn(name = "endereco_id")	
	)
	private List<Endereco> enderecos = new ArrayList<>();
	
	@OneToMany(mappedBy = "id.usuario")
	private Set<HorarioProcedimento> horariosProcedimentos = new HashSet<>();
	
	@JsonBackReference
	@OneToMany(mappedBy = "usuario")
	private Set<Produto> produtos = new HashSet<>();
	
	public Usuario() {

	}

	public Usuario(Integer id, String nome, String senha, String email, TipoUsuario tipoUsuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.tipoUsuario = tipoUsuario;
	}
	
	@JsonIgnore
	public List<Procedimento> getProcedimentos(){
		
		List<Procedimento> listaProcedimentos = new ArrayList<>();
		for(HorarioProcedimento x : horariosProcedimentos) {
			listaProcedimentos.add(x.getProcedimento());
		}
		
		return listaProcedimentos;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public Set<HorarioProcedimento> getHorariosProcedimentos() {
		return horariosProcedimentos;
	}

	public void setHorariosProcedimentos(Set<HorarioProcedimento> horariosProcedimentos) {
		this.horariosProcedimentos = horariosProcedimentos;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

}
