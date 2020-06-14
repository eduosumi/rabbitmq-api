package br.com.api.rabbitmqapi.business.rabbitmqConsumer;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SolicitacaoConsumer {

	@RabbitListener(queues = "solicitacao.queue")
	public void consumerSolicitacao(Message data) throws Exception {
		
		throw new AmqpRejectAndDontRequeueException("Enviado para a fila dlq");
	}
	
}
