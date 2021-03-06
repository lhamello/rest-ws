package br.unisc.pos.business.rest.response;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import br.unisc.pos.business.model.Perfume;
import br.unisc.pos.business.model.Produto;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PerfumeResponse extends RestResponse {

    private List<Perfume> listaResposta;

    public PerfumeResponse(Status status, Produto produto, String mensagem) {
        super.setEntidadeResposta(produto);
        super.setMensagem(mensagem);
        this.setParametrosSuperClasse(status, null);
    }

    public PerfumeResponse(Status status, List<Perfume> perfumes) {
        this.listaResposta = perfumes;
        this.setParametrosSuperClasse(status, perfumes.size());
    }

    public List<Perfume> getListaResposta() {
        return listaResposta;
    }

    public void setListaResposta(List<Perfume> listaResposta) {
        this.listaResposta = listaResposta;
    }

    private void setParametrosSuperClasse(Status status, Integer numRegistrosRetornados) {
        super.setCodigoStatus(status.getStatusCode());
        super.setFamiliaStatus(status.getFamily());
        super.setRazaoStatus(status.getReasonPhrase());
        super.setNumRegistrosRetornados(numRegistrosRetornados);
    }
}
