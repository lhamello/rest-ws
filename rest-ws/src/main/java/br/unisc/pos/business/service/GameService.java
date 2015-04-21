package br.unisc.pos.business.service;

import javax.inject.Inject;

import br.unisc.pos.business.dao.GameDAO;
import br.unisc.pos.business.model.Game;
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
