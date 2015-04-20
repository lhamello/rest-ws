package br.unisc.pos.infra;

import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.Status.Family;

public class Erro {

    private int status;
    private Family categoria;
    private String razao;
    private String mensagemErro;

    public Erro(Status status, String mensagem) {
        this.status = status.getStatusCode();
        this.razao = status.getReasonPhrase();
        this.categoria = status.getFamily();
        this.mensagemErro = mensagem;
    }

    public int getStatus() {
        return status;
    }

    public Family getCategoria() {
        return categoria;
    }

    public String getRazao() {
        return razao;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }
}
