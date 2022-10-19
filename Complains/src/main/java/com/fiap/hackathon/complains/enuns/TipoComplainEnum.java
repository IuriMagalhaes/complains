package com.fiap.hackathon.complains.enuns;

public enum TipoComplainEnum {

    CANCELAMENTO("CANC"),
    DEVOLUCAO_REEMBOLSO("REEM"),
	ENTREGA("ENTR"),
	NOTA_FISCAL("NF"),
	PAGAMENTO("PAG"),
	DANIFICADO_INCORRETO("PROD"),
	OUTROS("OUT");
    
    private String descricao;

    TipoComplainEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
