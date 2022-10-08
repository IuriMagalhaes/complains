package com.fiap.hackathon.complains.service;

import java.util.List;

import com.fiap.hackathon.complains.dto.ComplainsDTO;
import com.fiap.hackathon.complains.dto.NovaComplainDTO;

public interface ComplainsService {
	
	List<ComplainsDTO> listarComplains();
	ComplainsDTO buscarComplainPorId(Long id);
	void criar(NovaComplainDTO novaComplainDTO);
	ComplainsDTO atualizar(Long id, NovaComplainDTO novaComplainDTO);
	void deletarComplain(Long id);
	
}
