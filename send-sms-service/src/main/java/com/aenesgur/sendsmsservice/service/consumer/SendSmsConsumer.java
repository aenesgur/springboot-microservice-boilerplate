package com.aenesgur.sendsmsservice.service.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class SendSmsConsumer {
    @KafkaListener(topics = "send.sms", groupId = "send-sms-id")
    public void handleSendSmsEvent(String userPhoneNumber){
        log.info("Sms sent to number: {}", userPhoneNumber);
    }
}
