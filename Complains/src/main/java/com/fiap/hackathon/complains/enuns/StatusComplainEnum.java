package com.fiap.hackathon.complains.enuns;

public enum StatusComplainEnum {

    ABERTO("Aberto"),
    FECHADO("Fechado");
    
    private String descricao;

    StatusComplainEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
