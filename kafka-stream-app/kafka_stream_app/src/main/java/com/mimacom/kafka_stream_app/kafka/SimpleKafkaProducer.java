package com.mimacom.kafka_stream_app.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;

@Service
public class SimpleKafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private MeterRegistry meterRegistry;

    public void sendMessage(String msg) {
        Counter messagesSentCounter = meterRegistry.counter("custom_kafka_producer_messages_sent");
        Timer sendMessageTimer = meterRegistry.timer("custom_kafka_producer_send_timer");

        Timer.Sample sample = Timer.start();
        kafkaTemplate.send("sentences", "len-"+msg.length(), msg);

        sample.stop(sendMessageTimer);
        messagesSentCounter.increment();
    }
}
