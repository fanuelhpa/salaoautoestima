package com.fandev.salaoautoestima.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class HorarioProcedimento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private HorarioProcedimentoPK id = new HorarioProcedimentoPK();
	
	private Date hora;
	private Double desconto;
	
	public HorarioProcedimento() {
		
	}
	
	public HorarioProcedimento(Usuario usuario, Procedimento procedimento, Date hora, Double desconto) {
		super();
		id.setProcedimento(procedimento);
		id.setUsuario(usuario);
		this.hora = hora;
		this.desconto = desconto;	
	}

	public Procedimento getProcedimento() {
		return id.getProcedimento();
	}
	
	public Usuario getUsuario() {
		return id.getUsuario();
	}
	
	public HorarioProcedimentoPK getId() {
		return id;
	}

	public void setId(HorarioProcedimentoPK id) {
		this.id = id;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}
	
	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
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
		HorarioProcedimento other = (HorarioProcedimento) obj;
		return Objects.equals(id, other.id);
	}

}
