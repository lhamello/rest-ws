package br.unisc.pos.business.rest.response;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import br.unisc.pos.business.model.Computador;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ComputadorResponse extends RestResponse {

    private List<Computador> listaResposta;

    public ComputadorResponse(Status status, List<Computador> computadores) {
        this.listaResposta = computadores;
        this.setParametrosSuperClasse(status, computadores.size());
    }

    public List<Computador> getListaResposta() {
        return listaResposta;
    }

    public void setListaResposta(List<Computador> listaResposta) {
        this.listaResposta = listaResposta;
    }

    private void setParametrosSuperClasse(Status status, int numRegistrosRetornados) {
        super.setCodigoStatus(status.getStatusCode());
        super.setFamiliaStatus(status.getFamily());
        super.setRazaoStatus(status.getReasonPhrase());
        super.setNumRegistrosRetornados(numRegistrosRetornados);
    }
}
