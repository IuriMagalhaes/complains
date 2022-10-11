package com.fiap.hackathon.complains.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MessageServiceProducer {

    private AmazonSQS amazonSQS;

    @Autowired
    public MessageServiceProducer(AmazonSQS amazonSQS) {
        this.amazonSQS = amazonSQS;
    }


    public void sentToQueue(final String queueName, final String message) {
        amazonSQS.sendMessage(new SendMessageRequest()
                .withQueueUrl(queueName)
                .withMessageBody(message)
                );
    }

}
