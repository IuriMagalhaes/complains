package com.fiap.hackathon.complains.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.fiap.hackathon.complains.dto.ComplainsDTO;
import com.fiap.hackathon.complains.dto.NovaComplainDTO;
import com.fiap.hackathon.complains.service.ComplainsService;

@Service
public class ComplainsServiceImpl implements ComplainsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ComplainsServiceImpl.class);
	
	private DynamoDBMapper mapper;
	
	public ComplainsServiceImpl(DynamoDBMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<ComplainsDTO> listarComplains() {
		return null;
	}

	@Override
	public ComplainsDTO buscarComplainPorId(Long id) {
		return mapper.load(ComplainsDTO.class, id);
	}

	@Override
	public void criar(NovaComplainDTO novaComplainDTO) {
		mapper.save(novaComplainDTO);
	}

	@Override
	public ComplainsDTO atualizar(Long id, NovaComplainDTO novaComplainDTO) {
		try {
			mapper.save(novaComplainDTO, buildDynamoDBSaveExpression(novaComplainDTO));
		} catch (ConditionalCheckFailedException exception) {
			LOGGER.error("dado invalido - " + exception.getMessage());
		}
		return null;
	}

	@Override
	public void deletarComplain(Long id) {
		mapper.delete(id);
	}
	
	private DynamoDBSaveExpression buildDynamoDBSaveExpression(NovaComplainDTO novaComplainDTO) {
		DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression();
		Map<String, ExpectedAttributeValue> expected = new HashMap<>();
		expected.put("Id", new ExpectedAttributeValue(new AttributeValue(novaComplainDTO.getId()))
				.withComparisonOperator(ComparisonOperator.EQ));
		saveExpression.setExpected(expected);
		return saveExpression;
	}

}
