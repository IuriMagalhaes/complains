package com.fiap.hackathon.complains.model.dto;

import java.util.Date;
import java.util.Optional;

import com.fiap.hackathon.complains.model.entity.Complains;
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

}
