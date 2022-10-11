package com.fiap.hackathon.complains.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.hackathon.complains.dto.ComplainsDTO;
import com.fiap.hackathon.complains.dto.NovaComplainDTO;
import com.fiap.hackathon.complains.service.ComplainsService;

@RestController
@RequestMapping("complains")
public class ComplainsController {

	private ComplainsService complainsService;

	public ComplainsController(ComplainsService complainsService) {
		this.complainsService = complainsService;
	}

	@GetMapping
	public List<ComplainsDTO> listarReclamacoes() {
		return complainsService.listarComplains();
	}

	@GetMapping("/{id}")
	public ComplainsDTO getComplainsByUd(@PathVariable(name = "id") String id) {
		return complainsService.buscarComplainPorId(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createComplain(@RequestBody NovaComplainDTO newComplainDTO) {
		complainsService.criar(newComplainDTO);
	}

	@PutMapping("/{id}")
	public ComplainsDTO updateComplain(@RequestBody NovaComplainDTO novaComplainDTO, @PathVariable String id) {
		return complainsService.atualizar(id, novaComplainDTO);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteComplain(@PathVariable String id) {
		complainsService.deletarComplain(id);
	}

}
