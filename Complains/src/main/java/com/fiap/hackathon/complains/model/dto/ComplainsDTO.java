package com.fiap.hackathon.complains.model.dto;

import java.util.Date;

import com.fiap.hackathon.complains.enuns.StatusComplainEnum;
import com.fiap.hackathon.complains.enuns.TipoComplainEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComplainsDTO {
	
	private String id;
	private Date dataCriacao;
	private Date dataAlteracao;
	private String usuario;
	private String descricaoReclamacao;
	private StatusComplainEnum status;
	private TipoComplainEnum tipoReclamacao;

}
