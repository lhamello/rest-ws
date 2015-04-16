package br.unisc.pos.produto.eletronico;

import br.unisc.pos.produto.Produto;

public class Eletronico extends Produto {

	private static final long serialVersionUID = 1L;

	private String marca;
	private Voltagem voltagem;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Voltagem getVoltagem() {
		return voltagem;
	}

	public void setVoltagem(Voltagem voltagem) {
		this.voltagem = voltagem;
	}
}
