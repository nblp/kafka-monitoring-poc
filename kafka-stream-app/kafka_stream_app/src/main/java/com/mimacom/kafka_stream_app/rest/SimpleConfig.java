package com.mimacom.kafka_stream_app.rest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mimacom.kafka_stream_app.rest")
public class SimpleConfig {

}
