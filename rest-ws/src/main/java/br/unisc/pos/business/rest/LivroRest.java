package br.unisc.pos.business.rest;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.unisc.pos.business.model.Livro;
import br.unisc.pos.business.service.LivroService;

@Path("/")
@Produces("application/json;charset=utf-8")
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class LivroRest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private LivroService livroService;
    
    @PUT
    @Path("computador/{id:[0-9][0-9]*}")
    @Consumes("application/json")
    public Response update(@PathParam("id") Integer id, Livro produto) {
        if (produto == null) {
            return Response.status(Status.BAD_REQUEST).build();
        }

        return Response.noContent().build();
    }
    
    @GET
    @Path("livros")
    public List<Livro> listarTodos(@Context Request request) {
        return livroService.listar(new Livro());
    }
}
