package br.com.zupacademy.guilherme.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.zupacademy.guilherme.casadocodigo.pais.Estado;
import br.com.zupacademy.guilherme.casadocodigo.pais.Pais;
import br.com.zupacademy.guilherme.casadocodigo.shared.validators.ExistsId;
import br.com.zupacademy.guilherme.casadocodigo.shared.validators.UniqueValue;

public class ClienteRequest {
	
	@NotBlank @Email @UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@NotBlank @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String documento;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String cep;
	
	@NotBlank
	private String cidade;
	
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long paisId;
	
	private Long estadoId;
	
	
	
	public Cliente converter(EntityManager manager) {
		
		Pais pais = manager.find(Pais.class, paisId);
		
		Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco, complemento, telefone, cep, cidade, pais);
		
		if(pais.possuiEstado(manager) && estadoId == null) {
		
			Assert.isTrue( !(pais.possuiEstado(manager) && estadoId == null), "Informe um estado para este país");
		
		}  
		
		if (pais.possuiEstado(manager)) {
			
			Estado estado = manager.find(Estado.class, estadoId);
			
			Assert.isTrue(estado != null, "Estado inexistente");
			Assert.isTrue(estado.getPais().getId() == pais.getId(), "Estado não pertence ao país informado" );
			
			cliente.setEstado(estado);
		}
		
		return cliente;
		
	}



	public String getEmail() {
		return email;
	}



	public String getNome() {
		return nome;
	}



	public String getSobrenome() {
		return sobrenome;
	}



	public String getDocumento() {
		return documento;
	}



	public String getEndereco() {
		return endereco;
	}



	public String getComplemento() {
		return complemento;
	}



	public String getTelefone() {
		return telefone;
	}



	public String getCep() {
		return cep;
	}



	public String getCidade() {
		return cidade;
	}



	public Long getPaisId() {
		return paisId;
	}

	public Long getEstadoId() {
		return estadoId;
	}
	
	
}
