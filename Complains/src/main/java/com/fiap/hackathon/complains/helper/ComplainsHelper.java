package com.fiap.hackathon.complains.helper;

import com.fiap.hackathon.complains.model.dto.ComplainsDTO;
import com.fiap.hackathon.complains.model.dto.NovaComplainDTO;
import com.fiap.hackathon.complains.model.entity.Complains;

import java.util.Optional;

public class ComplainsHelper {

    public static Complains createComplainsBuilder(NovaComplainDTO NovacomplainDTO){
        return Complains.builder()
                .usuario(NovacomplainDTO.getUsuario())
                .dataCriacao(NovacomplainDTO.getDataCriacao())
                .dataAlteracao(NovacomplainDTO.getDataAlteracao())
                .build();
    }

    public static ComplainsDTO complainsDTOBuilder(Complains complains){
        return ComplainsDTO.builder()
                .usuario(complains.getUsuario())
                .dataCriacao(complains.getDataCriacao())
                .dataAlteracao(complains.getDataAlteracao())
                .build();
    }

    public static Complains complainsUpdateBuilder(Complains complains, NovaComplainDTO NovacomplainDTO){
        return Complains.builder()
                .id(complains.getId())
                .usuario(NovacomplainDTO.getUsuario())
                .dataCriacao(NovacomplainDTO.getDataCriacao())
                .dataAlteracao(NovacomplainDTO.getDataAlteracao())
                .build();
    }

}
