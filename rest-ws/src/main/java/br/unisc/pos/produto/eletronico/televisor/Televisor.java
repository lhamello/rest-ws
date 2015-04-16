package br.unisc.pos.produto.eletronico.televisor;

import br.unisc.pos.produto.Produto;

public class Televisor extends Produto {

	private static final long serialVersionUID = 1L;

	private String polegada;

	public String getPolegada() {
		return polegada;
	}

	public void setPolegada(String polegada) {
		this.polegada = polegada;
	}
}
