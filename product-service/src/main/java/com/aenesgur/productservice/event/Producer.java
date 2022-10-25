package com.aenesgur.productservice.event;

import com.aenesgur.productservice.model.dto.ProductEventModel;
import com.aenesgur.productservice.model.dto.ProductRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer {
    private final String CREATE_PRODUCT_TOPIC = "create.product";
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendMessage(ProductEventModel productEventModel) throws JsonProcessingException {
        String productDtoAsString = objectMapper.writeValueAsString(productEventModel);
        kafkaTemplate.send(CREATE_PRODUCT_TOPIC, productDtoAsString);
        log.info("Sent product {}", productDtoAsString);
    }
}
