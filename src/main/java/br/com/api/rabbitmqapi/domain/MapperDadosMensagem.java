package br.com.api.rabbitmqapi.domain;

public class MapperDadosMensagem {

	public static DadosMensagemDto convert(DadosMensagemRequest request) {

		return new DadosMensagemDto(request.getAssunto(), request.getMensagem());
	}

}
