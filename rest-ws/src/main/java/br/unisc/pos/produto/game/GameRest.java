package br.unisc.pos.produto.game;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;

@Path("/")
@Produces("application/json;charset=utf-8")
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class GameRest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private GameService gameService;

    @GET
    @Path("games")
    public List<Game> listarTodos(@Context Request request) {
        return gameService.listar(new Game());
    }
}
