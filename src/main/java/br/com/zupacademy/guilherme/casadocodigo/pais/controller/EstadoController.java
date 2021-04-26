package br.com.zupacademy.guilherme.casadocodigo.pais.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.guilherme.casadocodigo.pais.Estado;
import br.com.zupacademy.guilherme.casadocodigo.pais.EstadoUnicoParaPaisValidator;
import br.com.zupacademy.guilherme.casadocodigo.pais.request.EstadoRequest;

@RestController
public class EstadoController {
	
	@PersistenceContext
	EntityManager manager;
	
	@Autowired
	EstadoUnicoParaPaisValidator estadoUnicoParaPais2;
	
	@InitBinder
	public void init(WebDataBinder binder) {
	
		binder.addValidators(estadoUnicoParaPais2);
	}
	
	@PostMapping("/api/estado")
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadoRequest estadoRequest) {
		
		Estado estado = estadoRequest.converter(manager);
		manager.persist(estado);
		
		return ResponseEntity.ok().build();
	}
}
