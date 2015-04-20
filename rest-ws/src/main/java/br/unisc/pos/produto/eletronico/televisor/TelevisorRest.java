package br.unisc.pos.produto.eletronico.televisor;

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
public class TelevisorRest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TelevisorService televisorService;

    @GET
    @Path("televisores")
    public List<Televisor> listarTodos(@Context Request request) {
        return televisorService.listar(new Televisor());
    }
}
