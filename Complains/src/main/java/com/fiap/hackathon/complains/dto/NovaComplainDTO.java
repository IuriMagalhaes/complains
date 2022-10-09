package com.fiap.hackathon.complains.dto;

import java.util.Date;

public class NovaComplainDTO {
	
	private Long id;
	private Date dataCriacao;
	private Date dataAlteracao;
	private String usuario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public NovaComplainDTO(Long id, Date dataCriacao, Date dataAlteracao, String usuario) {
		super();
		this.id = id;
		this.dataCriacao = dataCriacao;
		this.dataAlteracao = dataAlteracao;
		this.usuario = usuario;
	}
	
}
