package com.fiap.hackathon.complains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NovaComplainDTO {

    private String id;
    private Date dataCriacao;
    private Date dataAlteracao;
    private String usuario;
}
