package com.fiap.hackathon.complains.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

import com.fiap.hackathon.complains.enuns.StatusComplainEnum;
import com.fiap.hackathon.complains.enuns.TipoComplainEnum;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NovaComplainDTO {

	private Date dataCriacao;
	private Date dataAlteracao;
	private String usuario;
	private String descricaoReclamacao;
	private StatusComplainEnum status;
	private TipoComplainEnum tipoReclamacao;
}
