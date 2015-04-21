package br.unisc.pos.produto;

import java.io.Serializable;
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
import javax.ws.rs.core.Response.Status;

import br.unisc.pos.infra.Erro;

@Path("/")
@Produces("application/json;charset=utf-8")
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ProdutoRest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ProdutoService produtoService;
    
    @GET
    @Path("produto/{id:[0-9][0-9]*}")
    public Response buscarPorId(@PathParam("id") Long id, @Context Request request) {
        Produto produto;

        produto = produtoService.consultarChave(id);
        
        if (produto == null) {
            Erro erro = new Erro(Status.NOT_FOUND, "Id [" + id + "] não encontrado.");
            
            return Response.status(Status.NOT_FOUND).entity(erro).build();
        }

        CacheControl cacheControl = new CacheControl();
        cacheControl.setMaxAge(100);

        EntityTag tag = new EntityTag(Integer.toString(produto.hashCode()));

        Response.ResponseBuilder builder = request.evaluatePreconditions(tag);

        if (builder != null) {
            builder.cacheControl(cacheControl);

            return builder.build();
        }

        builder = Response.ok(produto);
        builder.cacheControl(cacheControl);
        builder.tag(tag);

        return builder.build();
    } 
    
    @GET
    @Path("produtos")
    public List<Produto> listarTodos(@Context Request request) {
        return produtoService.listar(new Produto());
    }
}
