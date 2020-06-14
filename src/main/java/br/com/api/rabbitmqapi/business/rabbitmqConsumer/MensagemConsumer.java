package br.com.api.rabbitmqapi.business.rabbitmqConsumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.api.rabbitmqapi.constantes.RabbitMQConstantes;

@Component
public class MensagemConsumer {
	
	private static final Logger LOG = LoggerFactory.getLogger(MensagemConsumer.class);
	
	@RabbitListener(queues = RabbitMQConstantes.QUEUE, concurrency = "1")
	public void consumerMensagem(Message data) throws IOException {
		
		try {
			
			String body = new String(data.getBody());
			
//			DadosMensagemDto dados = JsonUtil.parseAs(body, DadosMensagemDto.class);
			
			LOG.info("mensagem processada com sucesso: {}", body);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
}
