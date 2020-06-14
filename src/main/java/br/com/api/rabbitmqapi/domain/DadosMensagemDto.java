package br.com.api.rabbitmqapi.domain;

public class DadosMensagemDto {

	private String assunto;
	
	private String mensagem;

	public DadosMensagemDto(String assunto, String mensagem) {
		this.assunto = assunto;
		this.mensagem = mensagem;
	}
	
	public String getAssunto() {
		return assunto;
	}

	public String getMensagem() {
		return mensagem;
	}
	
}
