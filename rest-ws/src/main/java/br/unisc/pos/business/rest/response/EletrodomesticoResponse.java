package br.unisc.pos.business.rest.response;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import br.unisc.pos.business.model.Eletrodomestico;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class EletrodomesticoResponse extends RestResponse {

    private List<Eletrodomestico> listaResposta;

    public EletrodomesticoResponse(Status status, List<Eletrodomestico> eletrodomesticos) {
        this.listaResposta = eletrodomesticos;
        this.setParametrosSuperClasse(status, eletrodomesticos.size());
    }

    public List<Eletrodomestico> getListaResposta() {
        return listaResposta;
    }

    public void setListaResposta(List<Eletrodomestico> listaResposta) {
        this.listaResposta = listaResposta;
    }

    private void setParametrosSuperClasse(Status status, int numRegistrosRetornados) {
        super.setCodigoStatus(status.getStatusCode());
        super.setFamiliaStatus(status.getFamily());
        super.setRazaoStatus(status.getReasonPhrase());
        super.setNumRegistrosRetornados(numRegistrosRetornados);
    }
}
