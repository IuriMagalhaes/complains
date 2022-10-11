package com.fiap.hackathon.complains.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * SQS Producer
 */
@Service
public class MessageServiceProducer {

    private AmazonSQS amazonSQS;

    @Autowired
    public MessageServiceProducer(AmazonSQS amazonSQS) {
        this.amazonSQS = amazonSQS;
    }

    /**
     * Sends the message
     *
     * @param queueName
     * @param message
     */
    public void sentToQueue(final String queueName, final String message) {
        amazonSQS.sendMessage(new SendMessageRequest()
                .withQueueUrl(queueName)
                .withMessageBody(message)
                );
    }

    /**
     * Sends the message with headers
     *
     * @param queueName
     * @param message
     */
    public void sentToQueueWithHeader(final String queueName, final String message, final Map<String, String> header) {
        final Map<String, MessageAttributeValue> messageHeader = new HashMap<>();
        header.forEach((key, value) -> messageHeader.put(key, new MessageAttributeValue().withDataType("String").withStringValue(value)));
        amazonSQS.sendMessage(new SendMessageRequest()
                .withQueueUrl(queueName)
                .withMessageBody(message)
                .withMessageAttributes(messageHeader));
    }

    /**
     * Sends the message
     *
     * @param queueName
     * @param message
     */
    public void sentToQueueWithDelay(final String queueName, final String message, final Integer delaySeconds) {
        amazonSQS.sendMessage(new SendMessageRequest()
                .withQueueUrl(queueName)
                .withMessageBody(message)
                .withDelaySeconds(delaySeconds));
    }

}
