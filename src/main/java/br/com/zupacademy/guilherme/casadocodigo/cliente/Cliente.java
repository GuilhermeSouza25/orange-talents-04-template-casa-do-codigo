package br.com.zupacademy.guilherme.casadocodigo.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.zupacademy.guilherme.casadocodigo.pais.Estado;
import br.com.zupacademy.guilherme.casadocodigo.pais.Pais;

@Entity
public class Cliente {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	private String nome;
	private String sobrenome;
	private String documento;
	private String endereco;
	private String complemento;
	private String telefone;
	private String cep;
	private String cidade;
	
	@OneToOne
	private Pais pais;
	
	@OneToOne
	private Estado estado;
	
	
	public Long getId() {
		return id;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento,
			String telefone, String cep, String cidade, Pais pais) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.telefone = telefone;
		this.cep = cep;
		this.cidade = cidade;
		this.pais = pais;
	}
}
