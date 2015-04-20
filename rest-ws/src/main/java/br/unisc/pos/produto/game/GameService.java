package br.unisc.pos.produto.game;

import javax.inject.Inject;

import br.unisc.pos.infra.BaseService;

public class GameService extends BaseService<Game, Long> {

    private static final long serialVersionUID = 1L;

    @Inject
    private GameDAO gameDAO;

    @Override
    public void initDAO() {
        super.setDAO(gameDAO);
    }
}
