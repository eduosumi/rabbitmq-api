package br.com.api.rabbitmqapi.config.messaging;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.api.rabbitmqapi.constantes.RabbitMQConstantes;

@Configuration
public class MensagemRabbitMQ {

	@Bean
	 FanoutExchange fanoutExchangeMensagem() {
		return ExchangeBuilder.fanoutExchange(RabbitMQConstantes.FANOUT).durable(true).build();
	}

	@Bean
	 Queue queueMensagem() {

		return QueueBuilder.durable(RabbitMQConstantes.QUEUE).build();
	}

	@Bean
	Binding bindingMensagem() {

		return BindingBuilder.bind(this.queueMensagem()).to(this.fanoutExchangeMensagem());
	}

	@Bean
	 Queue queueProcessarEmail() {

		return QueueBuilder.durable(RabbitMQConstantes.QUEUE_PROCESSAR_EMAIL).build();
	}

	@Bean
	Binding bindingProcessarEmail() {

		return BindingBuilder.bind(this.queueProcessarEmail()).to(this.fanoutExchangeMensagem());
	}

}
