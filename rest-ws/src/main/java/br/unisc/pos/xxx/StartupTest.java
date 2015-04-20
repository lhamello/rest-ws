package br.unisc.pos.xxx;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import br.unisc.pos.produto.perfume.GeneroPerfume;
import br.unisc.pos.produto.perfume.Perfume;
import br.unisc.pos.produto.perfume.PerfumeService;

@Singleton
@Startup
public class StartupTest {

	@Inject
	private PerfumeService perfumeService;
	
	@PostConstruct
	public void teste() {
	    this.adicionarPerfumes();
		System.out.println("RODOU!!!!");
	}
	
	
	private void adicionarPerfumes() {
	    perfumeService.incluir(this.criarPerfume("Kayak", GeneroPerfume.MASCULINO, 100.0));
	    perfumeService.incluir(this.criarPerfume("Egeo", GeneroPerfume.MASCULINO, 70.0));
	    perfumeService.incluir(this.criarPerfume("Jequiti", GeneroPerfume.FEMININO, 55.0));
	}
	
	private Perfume criarPerfume(String descricao, GeneroPerfume genero, double preco) {
	    Perfume perfume = new Perfume();
	    perfume.setDescricao(descricao);
	    perfume.setGenero(genero);
	    perfume.setPreco(preco);
	    return perfume;
	}
}
