package br.unisc.pos.business.rest;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.unisc.pos.business.model.Eletronico;
import br.unisc.pos.business.rest.response.EletronicoResponse;
import br.unisc.pos.business.service.EletronicoService;

@Path("/")
@Produces("application/json;charset=utf-8")
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class EletronicoRest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EletronicoService eletronicoService;
    
    /**
     * Retorna todos os eletronicos cadastrados no banco de dados. Se não houver
     * nenhum eletronico cadastrado, retorna uma lista vazia.
     * <p>
     * Juntamente com os registros é retornado o status da transação:
     * <ul>
     * <li>200 ({@code Status.OK}), se a listagem retornar registros</li>
     * <li>204 ({@code Status.NOT_CONTENT}), se a listagem não retornar
     * registros</li>
     * </ul>
     * 
     * @return um objeto {@code Response} contendo a lista de eletronicos e o
     *         status da transação.
     * 
     * @see javax.ws.rs.core.Response
     * @see javax.ws.rs.core.Response.Status
     */
    @GET
    @Path("eletronicos")
    public Response listarTodos() {
        List<Eletronico> eletronicos = eletronicoService.listar(new Eletronico());
        Status status = Status.OK;

        if (eletronicos.isEmpty()) {
            status = Status.NO_CONTENT;
        }

        return Response.status(status).entity(new EletronicoResponse(status, eletronicos)).build();
    }
}
