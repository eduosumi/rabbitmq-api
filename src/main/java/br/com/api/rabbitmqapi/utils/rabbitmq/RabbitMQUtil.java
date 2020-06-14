package br.com.api.rabbitmqapi.utils.rabbitmq;

public interface RabbitMQUtil {

	String XDEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";
	
	String XDEAD_LETTER_EXCHANGE = "x-dead-letter-exchange";
	
	String XMESSAGE_TTL = "x-message-ttl";
}
