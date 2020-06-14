package br.com.api.rabbitmqapi.config.messaging;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SolicitacaoRabbitMQ {

	@Bean
	DirectExchange exchangeSolicitacao() {
		
		return ExchangeBuilder.directExchange("solicitacao.exchange").build();
	}
	
	@Bean
	DirectExchange exchangeSolicitacaoDlq() {
		
		return ExchangeBuilder.directExchange("solicitacao.exchange.dlx").build();
	}
	
	@Bean
	Queue queueSolicitacao() {
		
		return QueueBuilder.durable("solicitacao.queue")
				.deadLetterExchange("solicitacao.exchange.dlx")
				.deadLetterRoutingKey("solicitacao.routingkey")
				.build();
	}
	
	@Bean
	Queue queueSolicitacaoDlq() {
		
		return QueueBuilder.durable("solicitacao.queue.dlq").build();
	}
	
	@Bean
	Binding bidingSolicitacao() {
		
		return BindingBuilder.bind(queueSolicitacao()).to(exchangeSolicitacao()).with("solicitacao.exchange");
	}
	
	@Bean
	Binding bidingSolicitacaoDlq() {
		
		return BindingBuilder.bind(queueSolicitacaoDlq()).to(exchangeSolicitacaoDlq()).with("solicitacao.routingkey");
	}
	
}
