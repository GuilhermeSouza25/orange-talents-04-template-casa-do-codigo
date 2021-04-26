package br.com.zupacademy.guilherme.casadocodigo.livro.response;

import br.com.zupacademy.guilherme.casadocodigo.autor.Autor;

public class DetalheAutorLivroResponse {

	private String nome;
	private String descricao;

	public DetalheAutorLivroResponse(Autor autor) {
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
