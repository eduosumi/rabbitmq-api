package br.com.api.rabbitmqapi.business;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.api.rabbitmqapi.constantes.RabbitMQConstantes;
import br.com.api.rabbitmqapi.domain.DadosMensagemRequest;
import br.com.api.rabbitmqapi.domain.MapperDadosMensagem;
import br.com.api.rabbitmqapi.utils.JsonUtil;
import br.com.api.rabbitmqapi.utils.rabbitmq.RabbitMQPublish;

@Service
public class MensagemBusiness extends RabbitMQPublish {

	public void enviar(DadosMensagemRequest request) {

		String mensagemSend = JsonUtil.toJson(MapperDadosMensagem.convert(request));

		send(RabbitMQConstantes.FANOUT, RabbitMQConstantes.ROUTINGKEY, mensagemSend, UUID.randomUUID().toString());

		send(RabbitMQConstantes.DIRECT_EXCHANGE_SIMPLE_QUEUE, RabbitMQConstantes.ROUTINGKEY_SIMPLE_QUEUE, mensagemSend,
				UUID.randomUUID().toString());

		send("solicitacao.exchange", "solicitacao.routingkey", mensagemSend, UUID.randomUUID().toString());
	}

}
