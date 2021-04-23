package br.com.zupacademy.guilherme.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.guilherme.casadocodigo.autor.Autor;
import br.com.zupacademy.guilherme.casadocodigo.categoria.Categoria;
import br.com.zupacademy.guilherme.casadocodigo.shared.validators.ExistsId;
import br.com.zupacademy.guilherme.casadocodigo.shared.validators.UniqueValue;

public class LivroRequest {
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	private String sumario;
	
	@NotNull
	@Min(20)
	private BigDecimal preco;
	
	@NotNull
	@Min(100)
	private Integer paginas;
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;
	
	@Future
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	
	@NotNull
	@Min(value = 1)
	@ExistsId(domainClass = Categoria.class, fieldName = "id")
	private Long categoriaId;
	
	@NotNull
	@Min(value = 1)
	@ExistsId(domainClass = Autor.class, fieldName = "id")
	private Long autorId;
	
	
	public LivroRequest(@NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "titulo") String titulo,
			@NotBlank @Size(max = 500) String resumo, String sumario, @NotNull @Min(20) BigDecimal preco,
			@NotNull @Min(100) Integer paginas,
			@NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "isbn") String isbn,
			@NotNull @Min(1) @ExistsId(domainClass = Categoria.class, fieldName = "id") Long categoriaId,
			@NotNull @Min(1) @ExistsId(domainClass = Autor.class, fieldName = "id") Long autorId) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.categoriaId = categoriaId;
		this.autorId = autorId;
	}
	
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}
	
	public Long getAutorId() {
		return autorId;
	}	


	public Livro converter(EntityManager manager) {
		Autor autor = manager.find(Autor.class, autorId);
		Categoria categoria = manager.find(Categoria.class, categoriaId);
		
		Assert.state(autor != null, "Autor inexistente para o id : " + autorId);
		Assert.state(categoria != null, "Categoria inexistente para o id : " + categoriaId);
		
		return new Livro(titulo, resumo, sumario, preco, paginas, isbn, dataPublicacao, categoria, autor);
	}
}
