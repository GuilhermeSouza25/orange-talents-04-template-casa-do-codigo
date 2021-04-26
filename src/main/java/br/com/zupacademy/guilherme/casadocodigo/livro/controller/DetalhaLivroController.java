package br.com.zupacademy.guilherme.casadocodigo.livro.controller;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.Pattern;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.guilherme.casadocodigo.livro.Livro;
import br.com.zupacademy.guilherme.casadocodigo.livro.response.DetalheLivroResponse;

@RestController
@Validated
public class DetalhaLivroController {
	
	@PersistenceContext
	EntityManager manager;
	
	@GetMapping("/api/livro/{id}")
	public ResponseEntity<DetalheLivroResponse> detalhar(
		 @PathVariable(name = "id") 
		 @Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="Informe um valor numérico positivo") String id) {
		
		try {
			Livro livro = manager
					.createQuery("SELECT l From Livro l JOIN FETCH l.autor WHERE l.id = :id", Livro.class)
					.setParameter("id", Long.valueOf(id))
					.getSingleResult();
			
			return ResponseEntity.ok(new DetalheLivroResponse(livro));
			
		} catch (NoResultException e) {
			
			return ResponseEntity.notFound().build();
		}
		
		
		
	}
}
