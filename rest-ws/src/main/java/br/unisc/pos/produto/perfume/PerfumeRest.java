package br.unisc.pos.produto.perfume;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/")
@Produces("application/json;charset=utf-8")
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class PerfumeRest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PerfumeService perfumeService;

    
    @POST
    public Response inserir(Perfume perfume) {
        perfumeService.incluir(perfume);
        
        return Response.created(UriBuilder.fromResource(PerfumeRest.class).path(String.valueOf(perfume.getId())).build()).build();
    }
    
    @GET
    @Path("perfumes")
    public List<Perfume> listarTodos(@Context Request request) {
        return perfumeService.listar(new Perfume());
    }

}
