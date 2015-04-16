package br.unisc.pos.xxx;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class GameService implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private GameDAO gameDAO;

    public List<Game> listar(Game game) {
        return gameDAO.listar(game);
    }
}
