package br.unisc.pos.produto.livro;

public enum GeneroLivro {

	BIOGRAFIA("Biografia"), 
	CONTOS("Contos"), 
	CRONICA("Crônica"), 
	FICCAO("Ficção Científica"), 
	POESIA("Poesia"),
	POLICIAL("Policial"), 
	ROMANCE("Romance"),
	TERROR("Terror");

	private String genero;

	private GeneroLivro(String genero) {
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}
