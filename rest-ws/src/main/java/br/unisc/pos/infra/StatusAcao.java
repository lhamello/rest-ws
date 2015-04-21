package br.unisc.pos.infra;

import br.unisc.pos.produto.Produto;

public class StatusAcao {

    public enum StatusProduto {
        ATUALIZADO, DELETADO;
    }

    private Produto produto;
    private StatusProduto status;

    public StatusAcao(Produto produto, StatusProduto status) {
        this.produto = produto;
        this.status = status;
    }

    public Produto getProduto() {
        return produto;
    }

    public StatusProduto getStatus() {
        return status;
    }

}
