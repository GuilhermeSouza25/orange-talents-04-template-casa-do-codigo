package br.com.zupacademy.guilherme.casadocodigo.cliente;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.guilherme.casadocodigo.shared.Erro;

@RestController
public class ClienteController {
	
	@PersistenceContext
	EntityManager manager;
	
	
	@PostMapping("/api/cliente")
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid ClienteRequest clienteRequest) {
		
		try {
			
			Cliente cliente = clienteRequest.converter(manager);
			manager.persist(cliente);
			return ResponseEntity.ok("ID do cliente: " + cliente.getId());
			
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(new Erro(e.getMessage()));
		}
		
	}
}
