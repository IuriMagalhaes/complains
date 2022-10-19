package com.fiap.hackathon.complains.service;

import java.util.List;

import com.fiap.hackathon.complains.model.dto.ComplainsDTO;
import com.fiap.hackathon.complains.model.dto.NovaComplainDTO;
import org.springframework.web.multipart.MultipartFile;

public interface ComplainsService {
	
	List<ComplainsDTO> listarComplains();

	ComplainsDTO buscarComplainPorId(String id);

	ComplainsDTO criarComEvidencia(MultipartFile evidencia, NovaComplainDTO novaComplainDTO);
	
	ComplainsDTO criar(NovaComplainDTO novaComplainDTO);

	ComplainsDTO atualizar(String id, NovaComplainDTO novaComplainDTO);

	void deletarComplain(String id);

	void fecharComplain(ComplainsDTO complainsDTO);
	
}
