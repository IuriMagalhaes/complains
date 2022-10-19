package com.fiap.hackathon.complains.helper;

import com.fiap.hackathon.complains.enuns.StatusComplainEnum;
import com.fiap.hackathon.complains.model.dto.ComplainsDTO;
import com.fiap.hackathon.complains.model.dto.NovaComplainDTO;
import com.fiap.hackathon.complains.model.entity.Complains;

public class ComplainsHelper {

    public static Complains createComplainsBuilder(NovaComplainDTO novacomplainDTO){
        return Complains.builder()
                .usuario(novacomplainDTO.getUsuario())
                .dataCriacao(novacomplainDTO.getDataCriacao())
                .dataAlteracao(novacomplainDTO.getDataAlteracao())
                .descricaoReclamacao(novacomplainDTO.getDescricaoReclamacao())
                .status(StatusComplainEnum.ABERTO)
                .tipoReclamacao(novacomplainDTO.getTipoReclamacao())
                .build();
    }

    public static ComplainsDTO complainsDTOBuilder(Complains complains){
        return ComplainsDTO.builder()
                .id(complains.getId())
                .usuario(complains.getUsuario())
                .dataCriacao(complains.getDataCriacao())
                .dataAlteracao(complains.getDataAlteracao())
                .descricaoReclamacao(complains.getDescricaoReclamacao())
                .status(complains.getStatus())
                .tipoReclamacao(complains.getTipoReclamacao())
                .build();
    }

    public static Complains complainsUpdateBuilder(Complains complains, NovaComplainDTO novacomplainDTO){
        return Complains.builder()
                .id(complains.getId())
                .usuario(novacomplainDTO.getUsuario())
                .dataCriacao(novacomplainDTO.getDataCriacao())
                .dataAlteracao(novacomplainDTO.getDataAlteracao())
                .descricaoReclamacao(novacomplainDTO.getDescricaoReclamacao())
                .status(complains.getStatus())
                .tipoReclamacao(complains.getTipoReclamacao())
                .build();
    }

    public static Complains closeComplainsBuilder(ComplainsDTO complainsDTO){
        return Complains.builder()
                .id(complainsDTO.getId())
                .usuario(complainsDTO.getUsuario())
                .dataCriacao(complainsDTO.getDataCriacao())
                .dataAlteracao(complainsDTO.getDataAlteracao())
                .descricaoReclamacao(complainsDTO.getDescricaoReclamacao())
                .status(complainsDTO.getStatus())
                .tipoReclamacao(complainsDTO.getTipoReclamacao())
                .build();
    }



}
