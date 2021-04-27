package br.com.zupacademy.guilherme.casadocodigo.pais;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pais {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@SuppressWarnings("unused")
	private String nome;
	
	
	
	public Pais() {}
	
	public Pais(String nome) {
		this.nome = nome;
	}
	
	
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Boolean possuiEstado(EntityManager manager) {
		
		List<?> resultList = manager
    			.createQuery("SELECT 1 FROM Estado WHERE pais.id = :id" )
    			.setParameter("id", this.id)
    			.getResultList();
		
		return !resultList.isEmpty();
	}
}
