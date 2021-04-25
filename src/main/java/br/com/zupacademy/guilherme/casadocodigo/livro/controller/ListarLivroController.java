package br.com.zupacademy.guilherme.casadocodigo.livro.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.guilherme.casadocodigo.livro.Livro;
import br.com.zupacademy.guilherme.casadocodigo.livro.response.LivroListaResponse;

@RestController
@Validated
@RequestMapping("/api/livro")
public class ListarLivroController {
	
	@PersistenceContext
	EntityManager manager;
	
	@GetMapping
	public List<LivroListaResponse> listar(
			@Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="Informe um valor numérico positivo") String pagina) {
		
		Integer quanidade = 3;
		Integer posicaoInicial = (Integer.valueOf(pagina) - 1) * quanidade;
		
		List<Livro> livros = manager
				.createQuery("SELECT l FROM Livro l ORDER BY l.id DESC", Livro.class)
				.setFirstResult(posicaoInicial)
				.setMaxResults(quanidade)
				.getResultList();
		
		return LivroListaResponse.converter(livros);
	}
}
