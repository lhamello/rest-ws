package br.unisc.pos.xxx;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import br.unisc.pos.produto.livro.GeneroLivro;
import br.unisc.pos.produto.livro.Livro;
import br.unisc.pos.produto.livro.LivroService;
import br.unisc.pos.produto.perfume.GeneroPerfume;
import br.unisc.pos.produto.perfume.Perfume;
import br.unisc.pos.produto.perfume.PerfumeService;

@Singleton
@Startup
public class StartupTest {

    @Inject
    private LivroService livroService;
    
	@Inject
	private PerfumeService perfumeService;
	
	@PostConstruct
	public void teste() {
	    this.adicionarLivros();
	    this.adicionarPerfumes();
		System.out.println("RODOU!!!!");
	}
	
	private void adicionarLivros() {
	    livroService.incluir(this.criarLivro("George R. R. Martin", "As Crônicas de Gelo e Fogo - A Guerras dos Tronos", new Short("1"), GeneroLivro.FANTASIA, 32.40, "Livro que baseia a série: Game of Thrones"));
	    livroService.incluir(this.criarLivro("J. K. Rowling", "Harry Potter e a Pedro Filosofal", new Short("1"), GeneroLivro.FANTASIA, 25.90, null));
	}
	
	private void adicionarPerfumes() {
	    perfumeService.incluir(this.criarPerfume("Kayak", GeneroPerfume.MASCULINO, 100.0));
	    perfumeService.incluir(this.criarPerfume("Egeo", GeneroPerfume.MASCULINO, 70.0));
	    perfumeService.incluir(this.criarPerfume("Jequiti", GeneroPerfume.FEMININO, 55.0));
	}
	
	private Livro criarLivro(String autor, String descricao, Short edicao, GeneroLivro genero, double preco, String observacao) {
	    Livro livro = new Livro();
	    
	    livro.setAutor(autor);
	    livro.setDescricao(descricao);
	    livro.setEdicao(edicao);
	    livro.setGenero(genero);
	    livro.setPreco(preco);
	    livro.setObservacao(observacao);
	    
	    return livro;
	}
	
	private Perfume criarPerfume(String descricao, GeneroPerfume genero, double preco) {
	    Perfume perfume = new Perfume();
	    
	    perfume.setDescricao(descricao);
	    perfume.setGenero(genero);
	    perfume.setPreco(preco);
	    
	    return perfume;
	}
}
