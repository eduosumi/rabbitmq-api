package br.com.api.rabbitmqapi.business;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.api.rabbitmqapi.constantes.RabbitMQConstantes;

@Component
public class SimpleQueueDlqPublish {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendSimpleQueueDlq(Message messageFailed) {
		
		rabbitTemplate.send(RabbitMQConstantes.SIMPLE_QUEUE_DLQ, messageFailed);
	}
	
}
