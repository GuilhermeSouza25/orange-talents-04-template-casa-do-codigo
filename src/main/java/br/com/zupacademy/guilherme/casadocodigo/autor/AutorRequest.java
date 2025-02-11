package br.com.zupacademy.guilherme.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.guilherme.casadocodigo.shared.validators.UniqueValue;


public class AutorRequest {
	
	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@UniqueValue(domainClass = Autor.class, fieldName = "email")
	private String email;
	@NotBlank
	@Size(max = 400)
	private String descricao;

	
	public AutorRequest(
			@NotBlank String nome, 
			@NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}


	public String getEmail() {
		return email;
	}

	public Autor converter() {
		return new Autor(this.nome, this.email, this.descricao);
	}
}
