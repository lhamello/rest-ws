package br.unisc.pos.produto.jogoeletronico;

import br.unisc.pos.produto.Produto;

public class JogoEletronico extends Produto {

	private static final long serialVersionUID = 1L;

	private PlataformaJogoEletronico plataforma;
	private GeneroJogoEletronico genero;

	public PlataformaJogoEletronico getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(PlataformaJogoEletronico plataforma) {
		this.plataforma = plataforma;
	}

	public GeneroJogoEletronico getGenero() {
		return genero;
	}

	public void setGenero(GeneroJogoEletronico genero) {
		this.genero = genero;
	}
}
