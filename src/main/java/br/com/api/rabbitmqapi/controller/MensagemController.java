package br.com.api.rabbitmqapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.rabbitmqapi.business.MensagemBusiness;
import br.com.api.rabbitmqapi.domain.DadosMensagemRequest;

@RestController
@RequestMapping(value = "/mensagens")
public class MensagemController {

	@Autowired
	private MensagemBusiness mensagemBusiness;
	
	@PostMapping
	public ResponseEntity<String> cadastrar(@RequestBody DadosMensagemRequest request) {
		
		mensagemBusiness.enviar(request);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("criado com sucesso");
	}
	
}
