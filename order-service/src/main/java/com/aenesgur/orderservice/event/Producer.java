package com.aenesgur.orderservice.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class Producer {
    private final String CREATE_PRODUCT_TOPIC = "send.sms";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendEvent(String userPhoneNumber){
        kafkaTemplate.send(CREATE_PRODUCT_TOPIC, userPhoneNumber);
        log.info("Sent sms event {}", userPhoneNumber);
    }
}

