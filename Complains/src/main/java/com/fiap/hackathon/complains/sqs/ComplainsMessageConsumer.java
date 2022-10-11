package com.fiap.hackathon.complains.sqs;

import com.fiap.hackathon.complains.model.dto.ComplainsDTO;
import com.fiap.hackathon.complains.util.JsonUtil;
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

    @Value("${amazon.queue.attendance}")
    private String queueName;

    @JmsListener(destination = "${amazon.queue.attendance}")
    public void messageConsumer(@Payload String message) {
        ComplainsDTO complainsDTO = JsonUtil.readValue(message, ComplainsDTO.class);

        log.info("***** COMPLAIN UPDATED RECEIVED AFTER ATTENDANCE:  " + queueName + ", COMPLAIN USER: " + complainsDTO.getUsuario()
                + ", COMPLAIN ID: " + complainsDTO.getId());

        //chama service
    }

}
