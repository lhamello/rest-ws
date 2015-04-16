package br.unisc.pos.produto.eletronico.computador;

import br.unisc.pos.produto.Produto;

public class Computador extends Produto {

	private static final long serialVersionUID = 1L;

	private String sistemaOperacional;

	public String getSistemaOperacional() {
		return sistemaOperacional;
	}

	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}
}
