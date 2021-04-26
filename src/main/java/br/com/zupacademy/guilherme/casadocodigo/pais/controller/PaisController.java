package br.com.zupacademy.guilherme.casadocodigo.pais.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.guilherme.casadocodigo.pais.Pais;
import br.com.zupacademy.guilherme.casadocodigo.pais.request.PaisRequest;

@RestController
public class PaisController {
	
	@PersistenceContext
	EntityManager manager;
	
	@PostMapping("/api/pais")
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid PaisRequest paisRequest) {
		
		Pais pais = paisRequest.converter();
		manager.persist(pais);
		
		return ResponseEntity.ok().build();
	}
}
