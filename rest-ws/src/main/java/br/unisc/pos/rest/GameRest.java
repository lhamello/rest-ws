package br.unisc.pos.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import br.unisc.pos.xxx.Game;
import br.unisc.pos.xxx.GameService;

@Path("1.0/")
@Produces("application/json;charset=utf-8")
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class GameRest implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private GameService gameService;
    
    /**
     * @description finds a car based on its ID
     * @responseType com.cdi.crud.car.model.Car
     * @param id car ID
     * @status 404 car not found
     * @status 304 not modified
     * @status 200 car found successfully
     */
    @GET
    @Path("game/{id:[0-9][0-9]*}")
    public Response buscarPorId(@PathParam("id") Integer id, @Context Request request) {
        Game game = new Game();
        game.setId(1L);
        game.setNome("PES 2015");
        game.setPlataforma("PS4");
        game.setPreco(179.99);

        CacheControl cc = new CacheControl();
        cc.setMaxAge(100);
        EntityTag tag = new EntityTag(Integer.toString(game.hashCode()));
        Response.ResponseBuilder builder =  request.evaluatePreconditions(tag);
        if(builder != null){
            builder.cacheControl(cc);
            return builder.build();
        }
        builder = Response.ok(game);
        builder.cacheControl(cc);
        builder.tag(tag);
        return builder.build();
    }
    
    /**
     * @description finds a car based on its ID
     * @responseType com.cdi.crud.car.model.Car
     * @param id car ID
     * @status 404 car not found
     * @status 304 not modified
     * @status 200 car found successfully
     */
    @GET
    @Path("games")
    public List<Game> listarTodos(@Context Request request) {
        Game game = new Game();
        game.setId(1L);
        game.setNome("PES 2015");
        game.setPlataforma("PS4");
        game.setPreco(179.99);
        
        Game game1 = new Game();
        game1.setId(1L);
        game1.setNome("PES 2015");
        game1.setPlataforma("PS3");
        game1.setPreco(109.99);
        
        List<Game> games = new ArrayList<>();
        games.add(0, game);
        games.add(1, game1);
        
        //return gameService.listar(new Game());
        return games;
    }
    
}
