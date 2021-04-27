package br.com.zupacademy.guilherme.casadocodigo.pais;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Pais pais;
	
	public Estado() {}
	
	public Estado(String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}
	
	public Long getId() {
		return id;
	}
	
	public Pais getPais() {
		return pais;
	}
}
