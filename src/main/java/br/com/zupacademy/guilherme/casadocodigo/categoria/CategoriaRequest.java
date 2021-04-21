package br.com.zupacademy.guilherme.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {
	
	@NotBlank
	private String nome;
	
	@Deprecated
	public CategoriaRequest() {}
	
	public CategoriaRequest(
			@NotBlank String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public Categoria converter() {
		return new Categoria(this.nome);
	}
}
