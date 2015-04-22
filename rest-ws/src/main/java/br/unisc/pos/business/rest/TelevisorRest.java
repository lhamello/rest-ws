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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.unisc.pos.business.model.Televisor;
import br.unisc.pos.business.rest.response.TelevisorResponse;
import br.unisc.pos.business.service.TelevisorService;

@Path("/")
@Produces("application/json;charset=utf-8")
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class TelevisorRest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TelevisorService televisorService;

    /**
     * Atualiza um produto a partir de um obejto produto e seu id.
     * 
     * Juntamente com o registro incluído é retornado o status da transação:
     * <ul>
     * <li>200 ({@code Status.OK}), se a atualização do produto for realizada
     * com sucesso</li>
     * 
     * <li>400 ({@code Status.BAD_REQUEST}), se o id do produto informado não
     * existir ou se dados de controle forem informados no arquivo json</li>
     * 
     * <li>406 ({@code Status.NOT_ACCEPTABLE}), se houver algum erro de
     * validação e o produto não for atualizado</li>
     * 
     * <li>409 ({@code Status.CONFLICT}), se o id informado como parêmtro
     * divergir do id do produto descrito no arquivo json</li>
     * </ul>
     * 
     * @param id
     *            identificador do produto que será atualizado.
     * 
     * @param produto
     *            produto que será atualizado.
     * 
     * @return um objeto {@link Response} contendo o status da transação e
     *         também o produto, caso ele tenha sido alterado.
     */
    @Consumes("application/json")
    @Path("televisor/{id:[0-9][0-9]*}")
    @PUT
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response atualizar(@PathParam("id") Long id, final Televisor produto) {
        Televisor retorno = null;
        Status status = Status.OK;

        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Registro alterado com sucesso.");

        try {
            Televisor obj = televisorService.consultarChave(id);

            if (obj == null) {
                mensagem = new StringBuilder();
                mensagem.append("Produto [" + id + "] inexistente.");

                status = Status.BAD_REQUEST;
            } else if (!id.equals(produto.getId())) {
                mensagem = new StringBuilder();
                mensagem.append("Id informado como parâmetro é divergente do informado no arquivo json.");

                status = Status.CONFLICT;
            } else if (produto.getDataHoraInclusao() != null || produto.getDataHoraUltimaAlteracao() != null) {
                mensagem = new StringBuilder();
                mensagem.append("Campos de controle (dataHoraInclusao, dataHoraUltimaAlteracao) não devem ser informados manualmente no arquivo json.");

                status = Status.BAD_REQUEST;
            } else {
                produto.setDataHoraInclusao(obj.getDataHoraInclusao());

                retorno = televisorService.alterar(produto);
            }
        } catch (ConstraintViolationException ex) {
            mensagem = new StringBuilder();
            mensagem.append("Falha ao atualizar registro. Motivo = ");

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

        return Response.status(status).entity(new TelevisorResponse(status, retorno, mensagem.toString())).build();
    }
    
    /**
     * Inclui um televisor no banco de dados e retorna o televisor incluído.
     * <p>
     * Juntamente com o registro é retornado o status da transação:
     * <ul>
     * <li>201 ({@code Status.CREATED}), se o televisor for inserido com sucesso
     * </li>
     * 
     * <li>400 ({@code Status.BAD_REQUEST}), se dados de controle forem
     * informados no arquivo json</li>
     * 
     * <li>406 ({@code Status.NOT_ACCEPTABLE}), se houver algum erro de
     * validação e o televisor não for incluído</li>
     * </ul>
     * 
     * @param televisor
     *            televisor que será incluído.
     * 
     * @return um objeto {@link Response} contendo o status da transação e
     *         também o televisor, caso ele tenha sido incluído.
     */
    @Consumes("application/json")
    @Path("televisor")
    @POST
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response incluir(final Televisor televisor) {
        Televisor retorno = null;
        Status status = Status.CREATED;

        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Registro incluído com sucesso.");

        try {
            if (televisor.getDataHoraInclusao() != null || televisor.getDataHoraUltimaAlteracao() != null) {
                mensagem = new StringBuilder();
                mensagem.append("Campos de controle (dataHoraInclusao, dataHoraUltimaAlteracao) não devem ser informados manualmente no arquivo json.");

                status = Status.BAD_REQUEST;
            } else {
                retorno = televisorService.incluir(televisor);
            }
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

        return Response.status(status).entity(new TelevisorResponse(status, retorno, mensagem.toString())).build();
    }

    /**
     * Retorna todos os televisores cadastrados no banco de dados. Se não houver
     * nenhum televisor cadastrado, retorna uma lista vazia.
     * <p>
     * Juntamente com os registros é retornado o status da transação:
     * <ul>
     * <li>200 ({@code Status.OK}), se a listagem retornar registros</li>
     * <li>204 ({@code Status.NOT_CONTENT}), se a listagem não retornar
     * registros</li>
     * </ul>
     * 
     * @return um objeto {@code Response} contendo a lista de televisores e o
     *         status da transação.
     * 
     * @see javax.ws.rs.core.Response
     * @see javax.ws.rs.core.Response.Status
     */
    @GET
    @Path("televisores")
    public Response listarTodos() {
        List<Televisor> televisores = televisorService.listar(new Televisor());
        Status status = Status.OK;

        if (televisores.isEmpty()) {
            status = Status.NO_CONTENT;
        }

        return Response.status(status).entity(new TelevisorResponse(status, televisores)).build();
    }
}
