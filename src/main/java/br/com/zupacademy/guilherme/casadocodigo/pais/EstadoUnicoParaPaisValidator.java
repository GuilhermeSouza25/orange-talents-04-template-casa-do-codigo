package br.com.zupacademy.guilherme.casadocodigo.pais;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.guilherme.casadocodigo.pais.request.EstadoRequest;

@Component
public class EstadoUnicoParaPaisValidator implements Validator {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean supports(Class<?> clazz) {
		return EstadoRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
//		if (errors.hasErrors()) {
//			return;
//		}
	
		EstadoRequest request = (EstadoRequest) target;
		
		List<?> resultList = manager
    			.createQuery("SELECT 1 FROM Estado WHERE nome =:nome AND pais.id = :id" )
    			.setParameter("nome", request.getNome())
    			.setParameter("id", request.getIdPais())
    			.getResultList();
		
		if(!resultList.isEmpty()) {
			errors.rejectValue("nome", null, "Já existe um estado com o mesmo nome para este país");
		}
	}

}
