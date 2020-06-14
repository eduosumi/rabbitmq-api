package br.com.api.rabbitmqapi.domain;

import java.io.Serializable;

public class DadosMensagemRequest implements Serializable {

	private static final long serialVersionUID = -8418152824936329176L;

	private String assunto;
	
	private String mensagem;
	
	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
