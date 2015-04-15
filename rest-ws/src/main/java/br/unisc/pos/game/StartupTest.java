package br.unisc.pos.game;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class StartupTest {

	@Inject
	private GameService gameService;
	
	@PostConstruct
	public void teste() {
		gameService.listar(new Game());
		
		System.out.println("RODOU!!!!");
	}
}
