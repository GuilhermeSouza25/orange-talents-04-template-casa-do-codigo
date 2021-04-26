package br.com.zupacademy.guilherme.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.guilherme.casadocodigo.autor.Autor;
import br.com.zupacademy.guilherme.casadocodigo.categoria.Categoria;

@Entity
public class Livro {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
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
	private String isbn;
	
	@Future
	private LocalDate dataPublicao;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;
	
	@NotNull
	@ManyToOne
	private Autor autor;
	
	@Deprecated
	public Livro() {}
	
	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer paginas, @NotBlank String isbn,
			@Future LocalDate dataPublicao, Categoria categoria, Autor autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicao = dataPublicao;
		this.categoria = categoria;
		this.autor = autor;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}
	
	public String getSumario() {
		return sumario;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public Integer getPaginas() {
		return paginas;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public Autor getAutor() {
		return autor;
	}
}
