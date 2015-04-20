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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import br.unisc.pos.infra.Erro;

@Path("1.0/")
@Produces("application/json;charset=utf-8")
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class PerfumeRest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PerfumeService perfumeService;

    @GET
    @Path("perfume/{id:[0-9][0-9]*}")
    public Response buscarPorId(@PathParam("id") Long id, @Context Request request) {
        Perfume perfume;

        perfume = perfumeService.consultarChave(id);
        
        if (perfume == null) {
            Erro erro = new Erro(Status.NOT_FOUND, "Id [" + id + "] não encontrado.");
            
            return Response.status(Status.NOT_FOUND).entity(erro).build();
        }

        CacheControl cacheControl = new CacheControl();
        cacheControl.setMaxAge(100);

        EntityTag tag = new EntityTag(Integer.toString(perfume.hashCode()));

        Response.ResponseBuilder builder = request.evaluatePreconditions(tag);

        if (builder != null) {
            builder.cacheControl(cacheControl);

            return builder.build();
        }

        builder = Response.ok(perfume);
        builder.cacheControl(cacheControl);
        builder.tag(tag);

        return builder.build();
    }
    
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
