package br.com.api.rabbitmqapi.utils.rabbitmq;

import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class RabbitMQPublish {

	private static final String CONTENT_ENCOLDING = "UTF-8";
	
	private static final String CONTENT_TYPE = "application/json";
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void send(final String exchange, final String routingKey, final String payload, final String messageId) {
		
		this.rabbitTemplate.convertAndSend(exchange, routingKey, payload, m -> {
			m.getMessageProperties().setCorrelationId(messageId);
			m.getMessageProperties().setMessageId(messageId);
			m.getMessageProperties().setContentEncoding(CONTENT_ENCOLDING);
			m.getMessageProperties().setContentType(CONTENT_TYPE);
			m.getMessageProperties().getHeaders().put("ORIGIN", "RABBITMQ-API");
			m.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
			return m;
		});
	}
	
}
