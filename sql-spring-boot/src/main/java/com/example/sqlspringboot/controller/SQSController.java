package com.example.sqlspringboot.controller;

import com.example.sqlspringboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
public class SQSController {


    private QueueMessagingTemplate queueMessagingTemplate;

    @Autowired
    public SQSController(QueueMessagingTemplate queueMessagingTemplate) {
        this.queueMessagingTemplate = queueMessagingTemplate;
    }

    @Value("${cloud.aws.end-point.uri}")
    private String endPoint;

    @GetMapping("/put/{msg}")
    public void putMessagedToQueue(@PathVariable("msg") String message) {
        queueMessagingTemplate.send(endPoint, MessageBuilder.withPayload(message).build());
    }

    @SqsListener("myqueue-tNilay")
    public void loadMessagesFromQueue(/*String message*/ Person person) {
        System.out.println("Queue Messages: " + person);
    }
    @PostMapping("/put/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person)
    {
        queueMessagingTemplate.send(endPoint, MessageBuilder.withPayload(person).build());
        return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }
}
