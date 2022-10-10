package com.fiap.hackathon.complains.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.fiap.hackathon.complains.repository")
public class DynamoDbConfig {
	
	@Value("${amazon.acess.key}")
	private String awsAcessKey;
	
	@Value("${amazon.acess.secret-key}")
	private String awsSecretKey;
	
	@Value("${amazon.region}")
	private String awsRegion;
	
	@Value("${amazon.end-point.url}")	
	private String awsDynamoDBEndPoint;
	
	public AWSCredentialsProvider amazonAWSCredentialsProvider() {
		return new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAcessKey, awsSecretKey));
	}
	
	@Bean
	public DynamoDBMapperConfig dynamoDBMapperConfig() {return DynamoDBMapperConfig.DEFAULT;} 
	
	@Bean DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig config) {
		return new DynamoDBMapper(amazonDynamoDB, config);
	}
	
    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
    	return AmazonDynamoDBClientBuilder.standard().withCredentials(amazonAWSCredentialsProvider())
    			.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(awsDynamoDBEndPoint, awsRegion))
    			.build();
    }

}
