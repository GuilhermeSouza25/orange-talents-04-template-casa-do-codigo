package br.com.zupacademy.guilherme.casadocodigo.livro.response;

import java.math.BigDecimal;

import br.com.zupacademy.guilherme.casadocodigo.livro.Livro;

public class DetalheLivroResponse {

	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer paginas;
	private String isbn;
	private DetalheAutorLivroResponse autor;
	private String dataPublicao;

	public DetalheLivroResponse(Livro livro) {
		this.autor = new DetalheAutorLivroResponse(livro.getAutor());
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicao = livro.formataData("dd/MM/yyyy");
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

	public DetalheAutorLivroResponse getAutor() {
		return autor;
	}
	
	public String getDataPublicao() {
		return dataPublicao;
	}

}
