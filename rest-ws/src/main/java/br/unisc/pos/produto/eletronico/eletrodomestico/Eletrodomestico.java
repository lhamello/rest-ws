package br.unisc.pos.produto.eletronico.eletrodomestico;

import br.unisc.pos.produto.Produto;

public class Eletrodomestico extends Produto {

	private static final long serialVersionUID = 1L;

	private String cor;

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
}
