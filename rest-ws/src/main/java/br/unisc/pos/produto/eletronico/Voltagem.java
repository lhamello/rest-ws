package br.unisc.pos.produto.eletronico;

public enum Voltagem {

	V_110("110V"), V_220("220V"), V_110_220("110V/220V");

	private String voltagem;

	private Voltagem(String voltagem) {
		this.voltagem = voltagem;
	}

	public String getVoltagem() {
		return voltagem;
	}

	public void setVoltagem(String voltagem) {
		this.voltagem = voltagem;
	}
}
