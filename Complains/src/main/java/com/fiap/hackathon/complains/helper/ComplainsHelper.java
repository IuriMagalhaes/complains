package com.fiap.hackathon.complains.helper;

import com.fiap.hackathon.complains.enuns.ComplainsEnum;
import com.fiap.hackathon.complains.model.dto.ComplainsDTO;
import com.fiap.hackathon.complains.model.dto.NovaComplainDTO;
import com.fiap.hackathon.complains.model.entity.Complains;

public class ComplainsHelper {

    public static Complains createComplainsBuilder(NovaComplainDTO novacomplainDTO){
        return Complains.builder()
                .usuario(novacomplainDTO.getUsuario())
                .dataCriacao(novacomplainDTO.getDataCriacao())
                .dataAlteracao(novacomplainDTO.getDataAlteracao())
                .reclamacao(novacomplainDTO.getReclamacao())
                .status(ComplainsEnum.ABERTO.name())
                .build();
    }

    public static ComplainsDTO complainsDTOBuilder(Complains complains){
        return ComplainsDTO.builder()
                .id(complains.getId())
                .usuario(complains.getUsuario())
                .dataCriacao(complains.getDataCriacao())
                .dataAlteracao(complains.getDataAlteracao())
                .reclamacao(complains.getReclamacao())
                .status(complains.getStatus())
                .build();
    }

    public static Complains complainsUpdateBuilder(Complains complains, NovaComplainDTO novacomplainDTO){
        return Complains.builder()
                .id(complains.getId())
                .usuario(novacomplainDTO.getUsuario())
                .dataCriacao(novacomplainDTO.getDataCriacao())
                .dataAlteracao(novacomplainDTO.getDataAlteracao())
                .reclamacao(novacomplainDTO.getReclamacao())
                .status(complains.getStatus())
                .build();
    }

    public static Complains closeComplainsBuilder(ComplainsDTO complainsDTO){
        return Complains.builder()
                .id(complainsDTO.getId())
                .usuario(complainsDTO.getUsuario())
                .dataCriacao(complainsDTO.getDataCriacao())
                .dataAlteracao(complainsDTO.getDataAlteracao())
                .reclamacao(complainsDTO.getReclamacao())
                .status(complainsDTO.getStatus())
                .build();
    }



}
