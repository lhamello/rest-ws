package br.unisc.pos.produto.jogoeletronico;

public enum GeneroJogoEletronico {

	ACAO("Ação"), 
	AVENTURA("Aventura"), 
	CASUAL("Casual"), 
	CORRIDA("Corrida"), 
	ESPORTES("Esportes"),
	ESTRATEGIA("Estratégia"), 
	PLATAFORMA("Plataforma"),
	SIMULACAO("Simulação");

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
