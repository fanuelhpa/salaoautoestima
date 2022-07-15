package com.fandev.salaoautoestima.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Embeddable //Define a classe como subtipo de HorarioProcedimento. Anotação necessaria para id composto, no JPA
public class HorarioProcedimentoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
		@ManyToOne
		@JoinColumn(name = "usuario_id")
		private Usuario usuario;
		
		@ManyToOne
		@JoinColumn(name = "procedimento_id")
		private Procedimento procedimento;
		
		public Usuario getUsuario() {
			return usuario;
		}
		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
		public Procedimento getProcedimento() {
			return procedimento;
		}
		public void setProcedimento(Procedimento procedimento) {
			this.procedimento = procedimento;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(procedimento, usuario);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			HorarioProcedimentoPK other = (HorarioProcedimentoPK) obj;
			return Objects.equals(procedimento, other.procedimento) && Objects.equals(usuario, other.usuario);
		}

}
