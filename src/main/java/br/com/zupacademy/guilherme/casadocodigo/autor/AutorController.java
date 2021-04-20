package br.com.zupacademy.guilherme.casadocodigo.autor;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping
	public ResponseEntity<?> cadastrar(
			@RequestBody @Valid AutorRequest autorRequest) {
				
		Autor autor = autorRequest.converter();
		autorRepository.save(autor);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PostMapping(value ="/quantidade")
	public void fecha(int quantidade) {
		//AutorRequest autor = new AutorRequest("nome", "email", "descricao");
		//autor.abate(quantidade);
	}
}
