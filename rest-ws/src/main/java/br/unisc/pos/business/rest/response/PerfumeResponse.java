package br.unisc.pos.business.rest.response;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import br.unisc.pos.business.model.Perfume;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PerfumeResponse extends RestResponse {

    private List<Perfume> listaResposta;

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

    private void setParametrosSuperClasse(Status status, int numRegistrosRetornados) {
        super.setCodigoStatus(status.getStatusCode());
        super.setFamiliaStatus(status.getFamily());
        super.setRazaoStatus(status.getReasonPhrase());
        super.setNumRegistrosRetornados(numRegistrosRetornados);
    }
}
