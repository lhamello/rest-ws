package br.unisc.pos.produto.perfume;

import br.unisc.pos.produto.Produto;

public class Perfume extends Produto {

	private static final long serialVersionUID = 1L;

	private GeneroPerfume genero;

	public GeneroPerfume getGenero() {
		return genero;
	}

	public void setGenero(GeneroPerfume genero) {
		this.genero = genero;
	}
}
