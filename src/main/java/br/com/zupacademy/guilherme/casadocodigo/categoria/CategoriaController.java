package br.com.zupacademy.guilherme.casadocodigo.categoria;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	CategoriaRepository categoriaRepository;
	
	
	public CategoriaController(
			CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
//	@InitBinder
//	public void init(WebDataBinder binder) {
//	
//		binder.addValidators(nomeCategoriaDuplicadoValidator);
//	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(
			@RequestBody @Valid CategoriaRequest categoriaRequest) {
		
		Categoria categoria = categoriaRequest.converter();
		categoriaRepository.save(categoria);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}
