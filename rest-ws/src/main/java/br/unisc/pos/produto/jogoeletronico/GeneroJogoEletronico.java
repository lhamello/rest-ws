package br.unisc.pos.produto.jogoeletronico;

public enum GeneroJogoEletronico {

	ACAO("A��o"), 
	AVENTURA("Aventura"), 
	CASUAL("Casual"), 
	CORRIDA("Corrida"), 
	ESPORTES("Esportes"),
	ESTRATEGIA("Estrat�gia"), 
	PLATAFORMA("Plataforma"),
	SIMULACAO("Simula��o");

	private String genero;

	private GeneroJogoEletronico(String genero) {
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}
