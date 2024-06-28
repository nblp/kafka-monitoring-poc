package com.mimacom.kafka_stream_app.kafka;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.prometheus.metrics.core.metrics.Gauge;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class SimpleKafkaSteam {
    @Autowired
    private MeterRegistry meterRegistry;

    @Autowired
    public void main(StreamsBuilder builder) {
        Logger logger = LoggerFactory.getLogger(SimpleKafkaSteam.class);

        AtomicInteger foo = meterRegistry.gauge("custom_kafka_stream_foo", new AtomicInteger(0));

        KStream<String, String> source = builder.stream("sentences", Consumed.with(Serdes.String(), Serdes.String()));
        KTable<String, Long> wordCounts = source
        .peek((k,v) -> {logger.info("received : {} {}",k, v);foo.incrementAndGet();}) // may be triggered multiple time on failure
        .flatMapValues(sentence -> Arrays.asList(sentence.toLowerCase().split("\\s+")))
        .groupBy((key, word) -> word)
        .count();

        wordCounts.toStream()
        .peek((k,v) -> {logger.info("sent: {} {}",k,v);foo.decrementAndGet();})
        .to("words_counts", Produced.with(Serdes.String(), Serdes.Long()));
    }
}