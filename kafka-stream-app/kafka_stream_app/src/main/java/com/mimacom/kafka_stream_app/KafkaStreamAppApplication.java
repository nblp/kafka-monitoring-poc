package com.mimacom.kafka_stream_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
@EnableKafka
@EnableKafkaStreams
public class KafkaStreamAppApplication {

	Logger logger = LoggerFactory.getLogger(KafkaStreamAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KafkaStreamAppApplication.class, args);
	}

}
