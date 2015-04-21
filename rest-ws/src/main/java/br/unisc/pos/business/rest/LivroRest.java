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

import br.unisc.pos.business.model.Livro;
import br.unisc.pos.business.rest.response.LivroResponse;
import br.unisc.pos.business.service.LivroService;

@Path("/")
@Produces("application/json;charset=utf-8")
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class LivroRest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private LivroService livroService;

    @Consumes("application/json")
    @Path("livro")
    @POST
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response incluir(final Livro livro) {
        Livro retorno = null;
        Status status = Status.CREATED;

        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Registro incluído com sucesso.");

        try {
            retorno = livroService.incluir(livro);
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

        return Response.status(status).entity(new LivroResponse(status, retorno, mensagem.toString())).build();
    }

    /**
     * Retorna todos os livros cadastrados no banco de dados. Se não houver
     * nenhum livro cadastrado, retorna uma lista vazia.
     * <p>
     * Juntamente com os registros é retornado o status da transação:
     * <ul>
     * <li>200 ({@code Status.OK}), se a listagem retornar registros</li>
     * <li>204 ({@code Status.NOT_CONTENT}), se a listagem não retornar
     * registros</li>
     * </ul>
     * 
     * @return um objeto {@code Response} contendo a lista de livros e o status
     *         da transação.
     * 
     * @see javax.ws.rs.core.Response
     * @see javax.ws.rs.core.Response.Status
     */
    @GET
    @Path("livros")
    public Response listarTodos() {
        List<Livro> livros = livroService.listar(new Livro());
        Status status = Status.OK;

        if (livros.isEmpty()) {
            status = Status.NO_CONTENT;
        }

        return Response.status(status).entity(new LivroResponse(status, livros)).build();
    }
}
