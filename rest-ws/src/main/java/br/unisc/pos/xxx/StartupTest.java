package br.unisc.pos.xxx;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import br.unisc.pos.produto.jogoeletronico.GeneroJogoEletronico;
import br.unisc.pos.produto.jogoeletronico.JogoEletronico;
import br.unisc.pos.produto.jogoeletronico.JogoEletronicoService;
import br.unisc.pos.produto.jogoeletronico.PlataformaJogoEletronico;
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
    private JogoEletronicoService gameService;
    
    @Inject
    private LivroService livroService;
    
	@Inject
	private PerfumeService perfumeService;
	
	@PostConstruct
	public void teste() {
	    this.adicionarGames();
	    this.adicionarLivros();
	    this.adicionarPerfumes();
	    
		System.out.println("RODOU!!!!");
	}
	
	private void adicionarGames() {
	    gameService.incluir(this.criarGame("Pro Evolution Soccer 2015", GeneroJogoEletronico.ESPORTE, PlataformaJogoEletronico.PS4, 119.00));
	    gameService.incluir(this.criarGame("FIFA 2015", GeneroJogoEletronico.ESPORTE, PlataformaJogoEletronico.XBOX_ONE, 109.90));
	    gameService.incluir(this.criarGame("SimCity 2013", GeneroJogoEletronico.ESTRATEGIA, PlataformaJogoEletronico.PC, 99.00));
	    gameService.incluir(this.criarGame("Uncharted 3", GeneroJogoEletronico.AVENTURA, PlataformaJogoEletronico.PS3, 39.90));
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
	
	private JogoEletronico criarGame(String descricao, GeneroJogoEletronico genero, PlataformaJogoEletronico plataforma, double preco) {
	    JogoEletronico game = new JogoEletronico();
	    
	    game.setDescricao(descricao);
	    game.setGenero(genero);
	    game.setPlataforma(plataforma);
	    game.setPreco(preco);
	    
	    return game;
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
