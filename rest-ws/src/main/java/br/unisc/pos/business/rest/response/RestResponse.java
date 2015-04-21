package br.unisc.pos.business.rest.response;

import javax.ws.rs.core.Response.Status.Family;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import br.unisc.pos.infra.BaseEntity;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public abstract class RestResponse {

    private int codigoStatus;
    private Family familiaStatus;
    private String razaoStatus;
    private int numRegistrosRetornados;
    private BaseEntity<Long> entidadeResposta;

    public int getCodigoStatus() {
        return codigoStatus;
    }

    public void setCodigoStatus(int codigoStatus) {
        this.codigoStatus = codigoStatus;
    }

    public Family getFamiliaStatus() {
        return familiaStatus;
    }

    public void setFamiliaStatus(Family familiaStatus) {
        this.familiaStatus = familiaStatus;
    }

    public String getRazaoStatus() {
        return razaoStatus;
    }

    public void setRazaoStatus(String razaoStatus) {
        this.razaoStatus = razaoStatus;
    }

    public int getNumRegistrosRetornados() {
        return numRegistrosRetornados;
    }

    public void setNumRegistrosRetornados(int numRegistrosRetornados) {
        this.numRegistrosRetornados = numRegistrosRetornados;
    }

    public BaseEntity<Long> getEntidadeResposta() {
        return entidadeResposta;
    }

    public void setEntidadeResposta(BaseEntity<Long> entidadeResposta) {
        this.entidadeResposta = entidadeResposta;
    }

}
