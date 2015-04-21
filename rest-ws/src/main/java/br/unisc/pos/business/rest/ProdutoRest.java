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
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.unisc.pos.business.model.Produto;
import br.unisc.pos.business.rest.response.ProdutoResponse;
import br.unisc.pos.business.service.ProdutoService;
import br.unisc.pos.infra.Erro;
import br.unisc.pos.infra.StatusAcao;
import br.unisc.pos.infra.StatusAcao.StatusProduto;

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
            Erro erro = new Erro(Status.NOT_FOUND, "Id [" + id + "] n�o encontrado.");

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

    @DELETE
    @Path("produto/{id:[0-9][0-9]*}")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response deletarPorId(@PathParam("id") Long id) {
        Produto produto = produtoService.consultarChave(id);

        if (produto == null) {
            Erro erro = new Erro(Status.NOT_FOUND, "Id [" + id + "] n�o encontrado.");

            return Response.status(Status.NOT_FOUND).entity(erro).build();
        }

        produtoService.excluir(produto);

        return Response.status(Status.OK).entity(new StatusAcao(produto, StatusProduto.DELETADO)).build();
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
}
