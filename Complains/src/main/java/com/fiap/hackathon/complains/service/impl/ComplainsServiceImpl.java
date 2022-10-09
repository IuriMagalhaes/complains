package com.fiap.hackathon.complains.service.impl;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.fiap.hackathon.complains.dto.ComplainsDTO;
import com.fiap.hackathon.complains.dto.NovaComplainDTO;
import com.fiap.hackathon.complains.entity.Complains;
import com.fiap.hackathon.complains.repository.ComplainsRepository;
import com.fiap.hackathon.complains.service.ComplainsService;

@Service
public class ComplainsServiceImpl implements ComplainsService {
	
	private ComplainsRepository complainsRepository;
	
	public ComplainsServiceImpl(ComplainsRepository complainsRepository) {
		this.complainsRepository = complainsRepository;
	}

	@Override
	public List<ComplainsDTO> listarComplains() {
		List<Complains> complainsList;
		complainsList = complainsRepository.findAll();
		return complainsList
				.stream()
				.map(ComplainsDTO::new)
				.collect(Collectors.toList());
	}

	@Override
	public ComplainsDTO buscarComplainPorId(Long id) {
		Optional<Complains> complains = complainsRepository.findById(id);
		return new ComplainsDTO(complains);
	}

	@Override
	public ComplainsDTO criar(NovaComplainDTO novaComplainDTO) {
		Complains complains = new Complains(novaComplainDTO);
		Complains savedComplain = complainsRepository.save(complains);
		return new ComplainsDTO(savedComplain);
	}

	@Override
	public ComplainsDTO atualizar(Long id, NovaComplainDTO novaComplainDTO) {
		Optional<Complains> complains = complainsRepository.findById(id); 
		complains.orElseThrow().setId(novaComplainDTO.getId());
		complains.orElseThrow().setDataAlteracao(GregorianCalendar.getInstance().getTime());
		complains.orElseThrow().setUsuario(novaComplainDTO.getUsuario());
		
		Complains updatedComplain = complainsRepository.save(complains.get());
		return new ComplainsDTO(updatedComplain);
	}

	@Override
	public void deletarComplain(Long id) {
		complainsRepository.deleteById(id);
	}
	
}
