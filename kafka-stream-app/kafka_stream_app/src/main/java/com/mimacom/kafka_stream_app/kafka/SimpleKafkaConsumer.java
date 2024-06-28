package com.mimacom.kafka_stream_app.kafka;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SimpleKafkaConsumer {
    @Autowired
    private ResourceLoader resourceLoader;

    private final Logger logger = LoggerFactory.getLogger(SimpleKafkaConsumer.class);

    @KafkaListener(topics = "words_counts")
    public void listenGroupFoo(ConsumerRecord<String, Long> record) {
        try {
            String key = record.key();
            Long value = record.value();
            logger.info("Consumed message - Key: {}, Value: {}", key, value);
            Resource resource = resourceLoader.getResource("classpath:message-consummed.txt");
            logger.info(Paths.get(resource.getURI()).toString());
            FileWriter fileWriter = new FileWriter(Paths.get(resource.getURI()).toString(), true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(key + "/" +value.toString() + "\n");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
