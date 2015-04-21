package br.unisc.pos.business.rest;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.unisc.pos.business.model.Produto;
import br.unisc.pos.business.rest.response.ProdutoResponse;
import br.unisc.pos.business.service.ProdutoService;

@Path("/")
@Produces("application/json;charset=utf-8")
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ProdutoRest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ProdutoService produtoService;

    /**
     * Recebe o id de um produto, e retorna o produto correspondente no banco de
     * dados (se encontrado).
     * <p>
     * Também é retornado o status da transação:
     * <ul>
     * <li>200 ({@code Status.OK}), se o id corresponder à um produto no banco
     * de dados</li>
     * <li>400 ({@code Status.BAD_REQUEST}), se o id não corresponder à um
     * registro no banco de dados.</li>
     * </ul>
     * 
     * @param id
     *            identificador do produto consultado.
     * 
     * @return um objeto {@link Response} contendo o status da transação e o
     *         produto consultado (se ele existir).
     * 
     * @see javax.ws.rs.core.Response.Status
     */
    @GET
    @Path("produto/{id:[0-9][0-9]*}")
    public Response buscarPorId(@PathParam("id") Long id, @Context Request request) {
        return this.editarExcluir(id, false, "retornado com sucesso.");
    }

    /**
     * Recebe o id de um produto, verifica se o id é válido e ser for válida
     * exclui o produto. Se o produto for excluído, ele é retornado.
     * <p>
     * Também é retornado o status da transação:
     * <ul>
     * <li>200 ({@code Status.OK}), se o id informado for válido e a exclusão
     * for consumada</li>
     * <li>400 ({@code Status.BAD_REQUEST}), se o id não for válido e não for
     * encontrado produto para ser deletado.</li>
     * </ul>
     * 
     * @param id
     *            identificador do produto que será deletado.
     * 
     * @return um objeto {@link Response} contendo o status da transação e, se a
     *         exclusão foi consumada, também retorna o produto excluído.
     * 
     * @see javax.ws.rs.core.Response.Status
     */
    @DELETE
    @Path("produto/{id:[0-9][0-9]*}")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response deletarPorId(@PathParam("id") Long id) {
        return this.editarExcluir(id, true, "deletado com sucesso.");
    }

    /**
     * Retorna todos os produtos cadastrados no banco de dados. Se não houver
     * nenhum produto cadastrado, retorna uma lista vazia.
     * <p>
     * Juntamente com os registros é retornado o status da transação:
     * <ul>
     * <li>200 ({@code Status.OK}), se a listagem retornar registros</li>
     * <li>204 ({@code Status.NOT_CONTENT}), se a listagem não retornar
     * registros</li>
     * </ul>
     * 
     * @return um objeto {@code Response} contendo a lista de produtos e o
     *         status da transação.
     * 
     * @see javax.ws.rs.core.Response
     * @see javax.ws.rs.core.Response.Status
     */
    @GET
    @Path("produtos")
    public Response listarTodos() {
        List<Produto> produtos = produtoService.listar(new Produto());
        Status status = Status.OK;

        if (produtos.isEmpty()) {
            status = Status.NO_CONTENT;
        }

        return Response.status(status).entity(new ProdutoResponse(status, produtos)).build();
    }

    private Response editarExcluir(Long id, boolean exclusao, String sufixoMensagemSucesso) {
        Produto produto = produtoService.consultarChave(id);
        Status status = Status.OK;
        String mensagem;

        if (produto == null) {
            status = Status.BAD_REQUEST;
            mensagem = "Produto [" + id + "] não encontrado.";
        } else {

            if (exclusao) {
                produtoService.excluir(produto);
            }

            mensagem = "Produto [" + id + "] " + sufixoMensagemSucesso;
        }

        return Response.status(status).entity(new ProdutoResponse(status, produto, mensagem)).build();
    }
}
