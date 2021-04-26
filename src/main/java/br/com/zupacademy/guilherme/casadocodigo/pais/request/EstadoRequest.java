	package br.com.zupacademy.guilherme.casadocodigo.pais.request;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.guilherme.casadocodigo.pais.Estado;
import br.com.zupacademy.guilherme.casadocodigo.pais.Pais;
import br.com.zupacademy.guilherme.casadocodigo.shared.validators.ExistsId;
import br.com.zupacademy.guilherme.casadocodigo.shared.validators.UniqueValue;


public class EstadoRequest {
	
	@NotBlank
	private String nome;
	
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;
	
	
	public EstadoRequest(@NotBlank @UniqueValue(domainClass = Estado.class, fieldName = "nome") String nome,
			@NotNull @ExistsId(domainClass = Pais.class, fieldName = "id") Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Long getIdPais() {
		return idPais;
	}
	

	public Estado converter(EntityManager manager) {
		
		Pais pais = manager.find(Pais.class, this.idPais);
		
		return new Estado(this.nome, pais);
	}
}
