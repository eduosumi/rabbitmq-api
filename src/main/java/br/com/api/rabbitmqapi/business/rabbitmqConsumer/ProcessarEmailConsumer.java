package br.com.api.rabbitmqapi.business.rabbitmqConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.api.rabbitmqapi.constantes.RabbitMQConstantes;

@Component
public class ProcessarEmailConsumer {

	private static final Logger LOG = LoggerFactory.getLogger(ProcessarEmailConsumer.class);

	@RabbitListener(autoStartup = "true", queues = RabbitMQConstantes.QUEUE_PROCESSAR_EMAIL, concurrency = "1")
	public void consumerProcessarEmail(Message dados) {

		String body = new String(dados.getBody());

		LOG.info("dados processados com sucesso: {}", body);

	}

}
