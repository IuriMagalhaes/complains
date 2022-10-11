package com.fiap.hackathon.complains.model.entity;

import java.io.Serializable;
import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fiap.hackathon.complains.model.dto.NovaComplainDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamoDBTable(tableName ="complains")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Complains implements Serializable{

	private static final long serialVersionUID = 1L;

	@DynamoDBHashKey(attributeName = "id")
	@DynamoDBAutoGeneratedKey
	private String id;

	@DynamoDBAttribute
	private Date dataCriacao;

	@DynamoDBAttribute
	private Date dataAlteracao;

	@DynamoDBAttribute
	private String usuario;

	@DynamoDBAttribute
	private String reclamacao;


}