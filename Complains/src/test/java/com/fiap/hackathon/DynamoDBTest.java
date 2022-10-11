package com.fiap.hackathon;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.fiap.hackathon.complains.ComplainsApplication;
import com.fiap.hackathon.complains.entity.Complains;
import com.fiap.hackathon.complains.repository.ComplainsRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.GregorianCalendar;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ComplainsApplication.class)
@WebAppConfiguration
@ActiveProfiles("local")
@TestPropertySource(properties = {
  "amazon.acess.key=AKIATW5KNR2JB33O6RXG",
  "amazon.acess.secret-key=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",
  "amazon.end-point.url=dynamodb.us-east-1.amazonaws.com"})

public class DynamoDBTest {

    /*
    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    ComplainsRepository repository;


    @Before
    public void setup() throws Exception {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
        
        CreateTableRequest tableRequest = dynamoDBMapper
          .generateCreateTableRequest(Complains.class);
        tableRequest.setProvisionedThroughput(
          new ProvisionedThroughput(1L, 1L));
        amazonDynamoDB.createTable(tableRequest);
        
        //...

        dynamoDBMapper.batchDelete(
          (List<Complains>)repository.findAll());
    }

    @Test
    public void givenItemWithExpectedCost_whenRunFindAll_thenItemIsFound() { 
    	Complains novaReclamacao = new Complains("adasdas-asdasd-asdasd-asdas", GregorianCalendar.getInstance().getTime(), GregorianCalendar.getInstance().getTime(), "Teste");
        repository.save(novaReclamacao); 
        List<Complains> result = (List<Complains>) repository.findAll();

    }*/

}
