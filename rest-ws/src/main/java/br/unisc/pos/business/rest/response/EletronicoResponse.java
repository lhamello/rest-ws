package br.unisc.pos.business.rest.response;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import br.unisc.pos.business.model.Eletronico;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class EletronicoResponse extends RestResponse {

    private List<Eletronico> listaResposta;

    public EletronicoResponse(Status status, List<Eletronico> eletronicos) {
        this.listaResposta = eletronicos;
        this.setParametrosSuperClasse(status, eletronicos.size());
    }

    public List<Eletronico> getListaResposta() {
        return listaResposta;
    }

    public void setListaResposta(List<Eletronico> listaResposta) {
        this.listaResposta = listaResposta;
    }

    private void setParametrosSuperClasse(Status status, int numRegistrosRetornados) {
        super.setCodigoStatus(status.getStatusCode());
        super.setFamiliaStatus(status.getFamily());
        super.setRazaoStatus(status.getReasonPhrase());
        super.setNumRegistrosRetornados(numRegistrosRetornados);
    }
}
