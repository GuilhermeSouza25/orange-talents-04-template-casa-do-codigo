package br.com.zupacademy.guilherme.casadocodigo.shared.validators;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String> {

    //private String message;
	
	
	private String field;
	private Class<?> clazz;
	@PersistenceContext
	EntityManager manager;
	
	@Override
	public void initialize(UniqueValue params) {
		field = params.fieldName();
		clazz = params.domainClass();
	}
	
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintContext) {
    	
    	List<?> resultList = manager
    			.createQuery("SELECT 1 FROM " +clazz.getName()+ " WHERE " +field+ "=:value")
    			.setParameter("value", value)
    			.getResultList();
    	
    	Assert.state(resultList.size() <= 1, "Foi encontrado mais de um "+clazz.getName()+" com o atributo "+field+" = "+value);
    	
    	return resultList.isEmpty();
    }
}