package br.com.zupacademy.guilherme.casadocodigo.livro.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.guilherme.casadocodigo.livro.Livro;
import br.com.zupacademy.guilherme.casadocodigo.livro.LivroRepository;
import br.com.zupacademy.guilherme.casadocodigo.livro.LivroRequest;

@RestController
@RequestMapping("/api/livro")
public class CadastrarLivroController {
	
	LivroRepository livroRepository;
	
	@PersistenceContext
	EntityManager manager;
	
	
	public CadastrarLivroController(
			LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(
			@RequestBody @Valid LivroRequest livroRequest) {
		
		Livro livro = livroRequest.converter(manager);
		livroRepository.save(livro);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}
