package br.unisc.pos.produto.livro;

import br.unisc.pos.produto.Produto;

public class Livro extends Produto {

	private static final long serialVersionUID = 1L;

	private String autor;
	private Short edicao;
	private GeneroLivro genero;

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Short getEdicao() {
		return edicao;
	}

	public void setEdicao(Short edicao) {
		this.edicao = edicao;
	}

	public GeneroLivro getGenero() {
		return genero;
	}

	public void setGenero(GeneroLivro genero) {
		this.genero = genero;
	}
}
