package br.unisc.pos.teste;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import br.unisc.pos.business.model.Computador;
import br.unisc.pos.business.model.Eletrodomestico;
import br.unisc.pos.business.model.Eletronico;
import br.unisc.pos.business.model.Game;
import br.unisc.pos.business.model.Livro;
import br.unisc.pos.business.model.Perfume;
import br.unisc.pos.business.model.Produto;
import br.unisc.pos.business.model.Televisor;
import br.unisc.pos.business.service.ComputadorService;
import br.unisc.pos.business.service.EletrodomesticoService;
import br.unisc.pos.business.service.GameService;
import br.unisc.pos.business.service.LivroService;
import br.unisc.pos.business.service.PerfumeService;
import br.unisc.pos.business.service.TelevisorService;
import br.unisc.pos.enums.GeneroGame;
import br.unisc.pos.enums.GeneroLivro;
import br.unisc.pos.enums.GeneroPerfume;
import br.unisc.pos.enums.PlataformaGame;
import br.unisc.pos.enums.SistemaOperacional;
import br.unisc.pos.enums.Voltagem;

@Singleton
@Startup
public class StartupTest {

    @Inject
    private ComputadorService computadorService;

    @Inject
    private EletrodomesticoService eletrodomesticoService;

    @Inject
    private GameService gameService;

    @Inject
    private LivroService livroService;

    @Inject
    private PerfumeService perfumeService;

    @Inject
    private TelevisorService televisorService;

    @PostConstruct
    public void teste() {
        this.adicionarComputadores();
        this.adicionarEletrodomesticos();
        this.adicionarGames();
        this.adicionarLivros();
        this.adicionarPerfumes();
        this.adicionarTelevisores();

        System.out.println("RODOU!!!!");
    }

    private void adicionarComputadores() {
        computadorService.incluir(this.criarComputador("Inspiron i7 8GB 14", "Dell", 2300.00, SistemaOperacional.WINDOWS, "Placa de vídeo dedicada.", Voltagem.V110_220));
    }

    private void adicionarEletrodomesticos() {
        eletrodomesticoService.incluir(this.criarEletrodomestico("Batedeira", "Wallita", 78.99, "Preto", Voltagem.V110));
        eletrodomesticoService.incluir(this.criarEletrodomestico("Liquidificador", "Arno", 120.35, "Branco", Voltagem.V110_220));
        eletrodomesticoService.incluir(this.criarEletrodomestico("Fog�o", "Consul", 679.99, "Prata", Voltagem.V220));
    }

    private void adicionarGames() {
        gameService.incluir(this.criarGame("Pro Evolution Soccer 2015", GeneroGame.ESPORTE, PlataformaGame.PS4, 119.00));
        gameService.incluir(this.criarGame("FIFA 2015", GeneroGame.ESPORTE, PlataformaGame.XBOX_ONE, 109.90));
        gameService.incluir(this.criarGame("SimCity 2013", GeneroGame.ESTRATEGIA, PlataformaGame.PC, 99.00));
        gameService.incluir(this.criarGame("Uncharted 3", GeneroGame.AVENTURA, PlataformaGame.PS3, 39.90));
    }

    private void adicionarLivros() {
        livroService.incluir(this.criarLivro("George R. R. Martin", "As Cr�nicas de Gelo e Fogo - A Guerras dos Tronos", new Short("1"), GeneroLivro.FANTASIA, 32.40, "Livro que baseia a s�rie: Game of Thrones"));
        livroService.incluir(this.criarLivro("J. K. Rowling", "Harry Potter e a Pedro Filosofal", new Short("1"), GeneroLivro.FANTASIA, 25.90, null));
    }

    private void adicionarPerfumes() {
        perfumeService.incluir(this.criarPerfume("Kayak", GeneroPerfume.MASCULINO, 100.0));
        perfumeService.incluir(this.criarPerfume("Egeo", GeneroPerfume.MASCULINO, 70.0));
        perfumeService.incluir(this.criarPerfume("Jequiti", GeneroPerfume.FEMININO, 55.0));
    }

    private void adicionarTelevisores() {
        televisorService.incluir(this.criarTelevisor("Smart TV", "LG", 1359.00, new Short("40"), "FULL HD Wi-Fi 3 HDMI 2 USB 60 HZ", Voltagem.V110_220));
    }

    private Computador criarComputador(String descricao, String marca, double preco, SistemaOperacional so, String observacao, Voltagem voltagem) {
        Computador computador = new Computador();
        computador.setSistemaOperacional(so);

        return (Computador) this.criarEletronico(computador, marca, voltagem, descricao, observacao, preco);
    }

    private Eletrodomestico criarEletrodomestico(String descricao, String marca, double preco, String cor, Voltagem voltagem) {
        Eletrodomestico eletrodomestico = new Eletrodomestico();
        eletrodomestico.setCor(cor);

        return (Eletrodomestico) this.criarEletronico(eletrodomestico, marca, voltagem, descricao, null, preco);
    }

    private Eletronico criarEletronico(Eletronico eletronico, String marca, Voltagem voltagem, String descricao, String observacao, double preco) {
        eletronico.setMarca(marca);
        eletronico.setVoltagem(voltagem);

        return (Eletronico) this.criarProduto(eletronico, descricao, observacao, preco);
    }

    private Game criarGame(String descricao, GeneroGame genero, PlataformaGame plataforma, double preco) {
        Game game = new Game();
        game.setGenero(genero);
        game.setPlataforma(plataforma);

        return (Game) this.criarProduto(game, descricao, null, preco);
    }

    private Livro criarLivro(String autor, String descricao, Short edicao, GeneroLivro genero, double preco, String observacao) {
        Livro livro = new Livro();
        livro.setAutor(autor);
        livro.setEdicao(edicao);
        livro.setGenero(genero);

        return (Livro) this.criarProduto(livro, descricao, observacao, preco);
    }

    private Perfume criarPerfume(String descricao, GeneroPerfume genero, double preco) {
        Perfume perfume = new Perfume();
        perfume.setGenero(genero);

        return (Perfume) this.criarProduto(perfume, descricao, null, preco);
    }

    private Produto criarProduto(Produto produto, String descricao, String observacao, double preco) {
        produto.setDescricao(descricao);
        produto.setObservacao(observacao);
        produto.setPreco(preco);

        return produto;
    }

    private Televisor criarTelevisor(String descricao, String marca, double preco, Short polegada, String observacao, Voltagem voltagem) {
        Televisor televisor = new Televisor();
        televisor.setPolegada(polegada);

        return (Televisor) this.criarEletronico(televisor, marca, voltagem, descricao, observacao, preco);
    }
}
