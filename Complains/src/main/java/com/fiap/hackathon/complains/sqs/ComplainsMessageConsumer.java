package com.fiap.hackathon.complains.sqs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class ComplainsMessageConsumer {

    @JmsListener(destination = "${amazon.queue.attendance}")
    public void messageConsumer(@Headers Map<String, Object> messageAttributes, @Payload String message) {
        log.info(message);
    }
}
