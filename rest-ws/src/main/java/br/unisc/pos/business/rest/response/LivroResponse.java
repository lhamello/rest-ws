package br.unisc.pos.business.rest.response;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import br.unisc.pos.business.model.Livro;
import br.unisc.pos.business.model.Produto;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class LivroResponse extends RestResponse {

    private List<Livro> listaResposta;

    public LivroResponse(Status status, Produto produto, String mensagem) {
        super.setEntidadeResposta(produto);
        super.setMensagem(mensagem);
        this.setParametrosSuperClasse(status, null);
    }

    public LivroResponse(Status status, List<Livro> livros) {
        this.listaResposta = livros;
        this.setParametrosSuperClasse(status, livros.size());
    }

    public List<Livro> getListaResposta() {
        return listaResposta;
    }

    public void setListaResposta(List<Livro> listaResposta) {
        this.listaResposta = listaResposta;
    }

    private void setParametrosSuperClasse(Status status, Integer numRegistrosRetornados) {
        super.setCodigoStatus(status.getStatusCode());
        super.setFamiliaStatus(status.getFamily());
        super.setRazaoStatus(status.getReasonPhrase());
        super.setNumRegistrosRetornados(numRegistrosRetornados);
    }
}
