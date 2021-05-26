package com.example.kafkaconsumerdmeo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "book-topic", groupId = "group_id")
    public void consume(String message)
    {
        System.out.println("message = " + message);
    }
}
