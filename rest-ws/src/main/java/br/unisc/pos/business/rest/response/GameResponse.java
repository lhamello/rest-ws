package br.unisc.pos.business.rest.response;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import br.unisc.pos.business.model.Game;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class GameResponse extends RestResponse {

    private List<Game> listaResposta;

    public GameResponse(Status status, List<Game> games) {
        this.listaResposta = games;
        this.setParametrosSuperClasse(status, games.size());
    }

    public List<Game> getListaResposta() {
        return listaResposta;
    }

    public void setListaResposta(List<Game> listaResposta) {
        this.listaResposta = listaResposta;
    }

    private void setParametrosSuperClasse(Status status, int numRegistrosRetornados) {
        super.setCodigoStatus(status.getStatusCode());
        super.setFamiliaStatus(status.getFamily());
        super.setRazaoStatus(status.getReasonPhrase());
        super.setNumRegistrosRetornados(numRegistrosRetornados);
    }
}
