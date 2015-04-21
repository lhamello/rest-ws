package br.unisc.pos.business.rest.response;

import javax.ws.rs.core.Response.Status.Family;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import br.unisc.pos.infra.BaseEntity;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public abstract class RestResponse {

    private int codigoStatus;
    private String razaoStatus;
    private Family familiaStatus;
    private String mensagem;
    private Integer numRegistrosRetornados;
    private BaseEntity<Long> entidadeResposta;

    public int getCodigoStatus() {
        return codigoStatus;
    }

    public void setCodigoStatus(int codigoStatus) {
        this.codigoStatus = codigoStatus;
    }

    public String getRazaoStatus() {
        return razaoStatus;
    }

    public void setRazaoStatus(String razaoStatus) {
        this.razaoStatus = razaoStatus;
    }

    public Family getFamiliaStatus() {
        return familiaStatus;
    }

    public void setFamiliaStatus(Family familiaStatus) {
        this.familiaStatus = familiaStatus;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Integer getNumRegistrosRetornados() {
        return numRegistrosRetornados;
    }

    public void setNumRegistrosRetornados(Integer numRegistrosRetornados) {
        this.numRegistrosRetornados = numRegistrosRetornados;
    }

    public BaseEntity<Long> getEntidadeResposta() {
        return entidadeResposta;
    }

    public void setEntidadeResposta(BaseEntity<Long> entidadeResposta) {
        this.entidadeResposta = entidadeResposta;
    }
}
