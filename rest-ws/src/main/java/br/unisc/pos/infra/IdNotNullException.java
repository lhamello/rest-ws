package br.unisc.pos.infra;

public class IdNotNullException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public IdNotNullException(String mensagem) {
        super(mensagem);
    }
}
