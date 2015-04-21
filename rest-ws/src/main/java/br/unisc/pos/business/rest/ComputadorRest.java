package br.unisc.pos.business.rest;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.unisc.pos.business.model.Computador;
import br.unisc.pos.business.rest.response.ComputadorResponse;
import br.unisc.pos.business.service.ComputadorService;

@Path("/")
@Produces("application/json;charset=utf-8")
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ComputadorRest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ComputadorService computadorService;

    /**
     * Inclui um computador no banco de dados e retorna o computador incluído.
     * <p>
     * Juntamente com o registro incluído é retornado o status da transação:
     * <ul>
     * <li>201 ({@code Status.CREATED}), se o computador for inserido com
     * sucesso</li>
     * <li>406 ({@code Status.NOT_ACCEPTABLE}), se houver algum erro de
     * validação e o computador não for incluído</li>
     * </ul>
     * 
     * @param computador
     *            computador que será incluído.
     * 
     * @return um objeto {@link Response} contendo o status da transação e
     *         também o computador, caso ele tenha sido incluído.
     */
    @Consumes("application/json")
    @Path("computador")
    @POST
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response incluir(final Computador computador) {
        Computador retorno = null;
        Status status = Status.CREATED;

        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Registro incluído com sucesso.");

        try {
            retorno = computadorService.incluir(computador);
        } catch (ConstraintViolationException ex) {
            mensagem = new StringBuilder();
            mensagem.append("Falha ao incluir registro. Motivo = ");

            int i = 0;
            Set<ConstraintViolation<?>> set = ex.getConstraintViolations();

            for (ConstraintViolation<?> constraint : set) {

                if (i != 0) {
                    mensagem.append(", ");
                }

                mensagem.append(constraint.getPropertyPath().toString().toUpperCase());
                mensagem.append(" ");
                mensagem.append(constraint.getMessage());
                i++;
            }

            status = Status.NOT_ACCEPTABLE;
            mensagem.append(".");
        } catch (Exception idEx) {
            mensagem = new StringBuilder();
            mensagem.append("Falha ao incluir registro. Motivo = ");
            mensagem.append(idEx.getMessage());

            status = Status.NOT_ACCEPTABLE;
        }

        return Response.status(status).entity(new ComputadorResponse(status, retorno, mensagem.toString())).build();
    }

    /**
     * Retorna todos os computadores cadastrados no banco de dados. Se não
     * houver nenhum computador cadastrado, retorna uma lista vazia.
     * <p>
     * Juntamente com os registros é retornado o status da transação:
     * <ul>
     * <li>200 ({@code Status.OK}), se a listagem retornar registros</li>
     * <li>204 ({@code Status.NOT_CONTENT}), se a listagem não retornar
     * registros</li>
     * </ul>
     * 
     * @return um objeto {@code Response} contendo a lista de computadores e o
     *         status da transação.
     * 
     * @see javax.ws.rs.core.Response
     * @see javax.ws.rs.core.Response.Status
     */
    @GET
    @Path("computadores")
    public Response listarTodos() {
        List<Computador> computadores = computadorService.listar(new Computador());
        Status status = Status.OK;

        if (computadores.isEmpty()) {
            status = Status.NO_CONTENT;
        }

        return Response.status(status).entity(new ComputadorResponse(status, computadores)).build();
    }
}
