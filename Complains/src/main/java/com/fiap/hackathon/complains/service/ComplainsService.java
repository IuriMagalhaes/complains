package com.fiap.hackathon.complains.service;

import java.util.List;

import com.fiap.hackathon.complains.dto.ComplainsDTO;
import com.fiap.hackathon.complains.dto.NovaComplainDTO;

public interface ComplainsService {
	
	List<ComplainsDTO> listarComplains();
	ComplainsDTO buscarComplainPorId(String id);
	ComplainsDTO criar(NovaComplainDTO novaComplainDTO);
	ComplainsDTO atualizar(String id, NovaComplainDTO novaComplainDTO);
	void deletarComplain(String id);
	
}
