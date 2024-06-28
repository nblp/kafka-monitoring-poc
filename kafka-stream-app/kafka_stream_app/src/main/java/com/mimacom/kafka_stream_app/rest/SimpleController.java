package com.mimacom.kafka_stream_app.rest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mimacom.kafka_stream_app.kafka.SimpleKafkaConsumer;
import com.mimacom.kafka_stream_app.kafka.SimpleKafkaProducer;

@RestController
public class SimpleController {    
    @Autowired
    SimpleKafkaProducer producer;
    
    @Autowired
    SimpleKafkaConsumer consumer;

    private final Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @PostMapping("/api/messages")
    public ResponseEntity<String> produce(@RequestBody String input) {
        logger.info("POST {}", input);
        producer.sendMessage(input);
        return ResponseEntity.ok().body(input);
    }

    @GetMapping("/api/messages")
    public ResponseEntity<String> getMessages() {
        logger.info("GET endpoint called");
        return ResponseEntity.ok().body("ok");
    }
}
