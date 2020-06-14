package br.com.api.rabbitmqapi.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQ {

	@Bean
	Queue deadLetterQueue() {
		return QueueBuilder.durable("deadLetter.queue").build();
	}
	
}
