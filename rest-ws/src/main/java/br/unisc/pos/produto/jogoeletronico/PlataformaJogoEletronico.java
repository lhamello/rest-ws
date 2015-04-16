package br.unisc.pos.produto.jogoeletronico;

public enum PlataformaJogoEletronico {
	
	PC("PC"), 
	PSP_VITA("PS VITA"), 
	PSP("PSP"), 
	PS2("PS2"), 
	PS3("PS3"), 
	PS4("PS4"), 
	XBOX("XBOX"), 
	XBOX_360("XBOX 360"), 
	XBOX_ONE("XBOX ONE"), 
	WII("Nintendo WII"), 
	WII_U("Nintendo WII U"),
	N_3DS("Nintendo 3DS");

	private String plataforma;

	private PlataformaJogoEletronico(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
}
