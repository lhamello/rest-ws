package br.unisc.pos.business.rest.response;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import br.unisc.pos.business.model.Produto;
import br.unisc.pos.business.model.Televisor;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class TelevisorResponse extends RestResponse {

    private List<Televisor> listaResposta;
    
    public TelevisorResponse(Status status, Produto produto, String mensagem) {
        super.setEntidadeResposta(produto);
        super.setMensagem(mensagem);
        this.setParametrosSuperClasse(status, null);
    }
    
    public TelevisorResponse(Status status, List<Televisor> televisores) {
        this.listaResposta = televisores;
        this.setParametrosSuperClasse(status, televisores.size());
    }

    public List<Televisor> getListaResposta() {
        return listaResposta;
    }

    public void setListaResposta(List<Televisor> listaResposta) {
        this.listaResposta = listaResposta;
    }

    private void setParametrosSuperClasse(Status status, Integer numRegistrosRetornados) {
        super.setCodigoStatus(status.getStatusCode());
        super.setFamiliaStatus(status.getFamily());
        super.setRazaoStatus(status.getReasonPhrase());
        super.setNumRegistrosRetornados(numRegistrosRetornados);
    }
}
