package br.com.api.rabbitmqapi.constantes;

public interface RabbitMQConstantes {

	String ROUTINGKEY = "rabbitmq-api.routingkey";
	String FANOUT = "rabbitmq-api.fanout";
	String QUEUE = "rabbitmq-api.queue";
	String QUEUE_PROCESSAR_EMAIL = "rabbitmq-api.queue.processar.email";
	
	String DIRECT_EXCHANGE_SIMPLE_QUEUE = "rabbitmq-api.simple_queue.exchange";
	String QUEUE_SIMPLE_QUEUE = "rabbitmq-api.queue.simple.queue";
	String WAIT_SIMPLE_QUEUE = "rabbitmq-api.queue.simple.queue.wait";
	String SIMPLE_QUEUE_DLQ = "rabbitmq-api.queue.simple.queue.dlq";
	String ROUTINGKEY_SIMPLE_QUEUE = "rabbitmq-api.simple_queue.routingkey";
	
}
