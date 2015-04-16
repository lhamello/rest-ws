package br.unisc.pos.produto.perfume;

public enum GeneroPerfume {

	FEMININO("Feminino"), MASCULINO("Masculino");

	private String genero;

	private GeneroPerfume(String genero) {
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}
