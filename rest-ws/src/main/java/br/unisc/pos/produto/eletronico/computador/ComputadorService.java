package br.unisc.pos.produto.eletronico.computador;

import javax.inject.Inject;

import br.unisc.pos.infra.BaseService;

public class ComputadorService extends BaseService<Computador, Long> {

    private static final long serialVersionUID = 1L;

    @Inject
    private ComputadorDAO computadorDAO;

    @Override
    public void initDAO() {
        super.setDAO(computadorDAO);
    }
}
