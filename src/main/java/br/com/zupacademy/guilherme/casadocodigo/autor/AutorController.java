package br.com.zupacademy.guilherme.casadocodigo.autor;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autor")
public class AutorController {
	
	AutorRepository autorRepository;
	
	
	public AutorController(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
//	@InitBinder
//	public void init(WebDataBinder binder) {
//	
//		binder.addValidators(emailValidator);
//	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(
			@RequestBody @Valid AutorRequest autorRequest) {
				
		Autor autor = autorRequest.converter();
		autorRepository.save(autor);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}
