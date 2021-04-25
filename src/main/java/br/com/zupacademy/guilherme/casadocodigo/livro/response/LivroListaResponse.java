package br.com.zupacademy.guilherme.casadocodigo.livro.response;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.guilherme.casadocodigo.livro.Livro;

public class LivroListaResponse {

	private Long id;
	private String titulo;

	
	public LivroListaResponse(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public static List<LivroListaResponse> converter(List<Livro> livros) {

		return livros.stream().map(LivroListaResponse::new).collect(Collectors.toList());
	}
}
