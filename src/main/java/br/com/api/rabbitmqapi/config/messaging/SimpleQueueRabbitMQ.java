package br.com.api.rabbitmqapi.config.messaging;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.api.rabbitmqapi.constantes.RabbitMQConstantes;

@Configuration
public class SimpleQueueRabbitMQ {

	@Bean
	DirectExchange exchangeSimpleQueue() {

		return new DirectExchange(RabbitMQConstantes.DIRECT_EXCHANGE_SIMPLE_QUEUE);
	}

	@Bean
	Queue simpleQueue() {

		return QueueBuilder.durable(RabbitMQConstantes.QUEUE_SIMPLE_QUEUE)
				.deadLetterExchange(RabbitMQConstantes.DIRECT_EXCHANGE_SIMPLE_QUEUE)
				.deadLetterRoutingKey(RabbitMQConstantes.WAIT_SIMPLE_QUEUE)
				.build();
	}

	@Bean
	Queue filaDeEspera() {

		return QueueBuilder.durable(RabbitMQConstantes.WAIT_SIMPLE_QUEUE)
				.deadLetterExchange(RabbitMQConstantes.DIRECT_EXCHANGE_SIMPLE_QUEUE)
				.deadLetterRoutingKey(RabbitMQConstantes.ROUTINGKEY_SIMPLE_QUEUE)
				.ttl(10000)
				.build();
	}

	@Bean
	Queue SimpleQueueDlq() {

		return new Queue(RabbitMQConstantes.SIMPLE_QUEUE_DLQ);
	}

	@Bean
	Binding simpleQueueBinding() {

		return BindingBuilder.bind(this.simpleQueue()).to(this.exchangeSimpleQueue())
				.with(RabbitMQConstantes.ROUTINGKEY_SIMPLE_QUEUE);
	}

	@Bean
	Binding waitSimpleQueueBinding() {

		return BindingBuilder.bind(this.filaDeEspera()).to(this.exchangeSimpleQueue())
				.with(RabbitMQConstantes.WAIT_SIMPLE_QUEUE);
	}

	@Bean
	Binding SimpleQueueDlqBinding() {

		return BindingBuilder.bind(this.SimpleQueueDlq()).to(this.exchangeSimpleQueue())
				.with(RabbitMQConstantes.SIMPLE_QUEUE_DLQ);
	}

}
