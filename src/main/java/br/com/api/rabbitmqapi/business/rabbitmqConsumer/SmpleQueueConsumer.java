package br.com.api.rabbitmqapi.business.rabbitmqConsumer;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.api.rabbitmqapi.business.SimpleQueueDlqPublish;
import br.com.api.rabbitmqapi.constantes.RabbitMQConstantes;

@Component
public class SmpleQueueConsumer {

	private Logger logger = LoggerFactory.getLogger(SmpleQueueConsumer.class);
	
	@Autowired
	private SimpleQueueDlqPublish simpleQueueDlqPublish;

    @RabbitListener(autoStartup = "true", queues = RabbitMQConstantes.QUEUE_SIMPLE_QUEUE, concurrency = "1")
    public void consumerSimpleQueue(Message dados) throws Exception {
        
    	logger.info("Processando mensagem: {}", dados);
        
        if (hasExceededRetryCount(dados)) {
        	enviarDlq(dados);
            return;
        }
        
        throw new AmqpRejectAndDontRequeueException("forcando um erro. Enviado para a fila de espera");
    }

    private boolean hasExceededRetryCount(Message in) {
        List<Map<String, ?>> xDeathHeader = in.getMessageProperties().getXDeathHeader();
        if (xDeathHeader != null && xDeathHeader.size() >= 1) {
            Long count = (Long) xDeathHeader.get(0).get("count");
            return count >= 3;
        }

        return false;
    }

    private void enviarDlq(Message failedMessage) {
    	simpleQueueDlqPublish.sendSimpleQueueDlq(failedMessage);
    }
	
}
