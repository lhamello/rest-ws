package br.unisc.pos.produto.jogoeletronico;

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

@Path("1.0/")
@Produces("application/json;charset=utf-8")
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class JogoEletronicoRest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private JogoEletronicoService jogoEletronicoService;

    @GET
    @Path("games")
    public List<JogoEletronico> listarTodos(@Context Request request) {
        return jogoEletronicoService.listar(new JogoEletronico());
    }
}
