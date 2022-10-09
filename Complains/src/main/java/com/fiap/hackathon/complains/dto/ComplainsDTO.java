package com.fiap.hackathon.complains.dto;

import java.util.Date;
import java.util.Optional;

import com.fiap.hackathon.complains.entity.Complains;

public class ComplainsDTO {
	
	private String id;
	private Date dataCriacao;
	private Date dataAlteracao;
	private String usuario;
	
	public ComplainsDTO(Optional<Complains> complains) {
	}
	
	public ComplainsDTO(Complains savedComplain) {
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
}
