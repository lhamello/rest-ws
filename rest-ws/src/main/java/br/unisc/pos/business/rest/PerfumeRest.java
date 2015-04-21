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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.unisc.pos.business.model.Perfume;
import br.unisc.pos.business.rest.response.PerfumeResponse;
import br.unisc.pos.business.service.PerfumeService;
import br.unisc.pos.business.service.ProdutoService;

@Path("/")
@Produces("application/json;charset=utf-8")
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class PerfumeRest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PerfumeService perfumeService;
    @Inject
    ProdutoService produtoService;
    
    @PUT
    @Path("computador/{id:[0-9][0-9]*}")
    @Consumes("application/json")
    public Response update(@PathParam("id") Integer id, Perfume produto) {
        if (produto == null) {
            return Response.status(Status.BAD_REQUEST).build();
        }

        return Response.noContent().build();
    }
    
    /**
     * Retorna todos os perfumes cadastrados no banco de dados. Se não houver
     * nenhum perfume cadastrado, retorna uma lista vazia.
     * <p>
     * Juntamente com os registros é retornado o status da transação:
     * <ul>
     * <li>200 ({@code Status.OK}), se a listagem retornar registros</li>
     * <li>204 ({@code Status.NOT_CONTENT}), se a listagem não retornar
     * registros</li>
     * </ul>
     * 
     * @return um objeto {@code Response} contendo a lista de perfumes e o
     *         status da transação.
     * 
     * @see javax.ws.rs.core.Response
     * @see javax.ws.rs.core.Response.Status
     */
    @GET
    @Path("perfumes")
    public Response listarTodos() {
        List<Perfume> perfumes = perfumeService.listar(new Perfume());
        Status status = Status.OK;

        if (perfumes.isEmpty()) {
            status = Status.NO_CONTENT;
        }

        return Response.status(status).entity(new PerfumeResponse(status, perfumes)).build();
    }
}
