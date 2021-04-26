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
	private String nomeAutor;
	private String descricaoAutor;

	public DetalheLivroResponse(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.nomeAutor = livro.getAutor().getNome();
		this.descricaoAutor = livro.getAutor().getDescricao();
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

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getDescricaoAutor() {
		return descricaoAutor;
	}

}
