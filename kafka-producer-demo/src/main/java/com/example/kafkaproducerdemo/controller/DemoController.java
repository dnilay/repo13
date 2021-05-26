package com.example.kafkaproducerdemo.controller;

import com.example.kafkaproducerdemo.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class DemoController {

    @Autowired
    KafkaTemplate<String, Book> kafkaTemplate;

    private static final String TOPIC = "book-topic";

    @PostMapping("/publish")
    public void publishMessage(@RequestBody Book book)
    {
       log.info("message sent");
        kafkaTemplate.send(TOPIC, book);


    }
}
