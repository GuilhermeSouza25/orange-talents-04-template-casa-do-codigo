package br.com.zupacademy.guilherme.casadocodigo.pais.request;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.guilherme.casadocodigo.pais.Estado;
import br.com.zupacademy.guilherme.casadocodigo.pais.Pais;
import br.com.zupacademy.guilherme.casadocodigo.shared.validators.UniqueValue;

public class PaisRequest {
	
	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;
	
	@Deprecated
	public PaisRequest() {}
	
	public PaisRequest(@NotBlank @UniqueValue(domainClass = Estado.class, fieldName = "nome") String nome) {
		this.nome = nome;
	}

	public Pais converter() {
		return new Pais(this.nome);
	}
	
	public String getNome() {
		return nome;
	}
	
}
