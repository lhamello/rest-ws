package br.unisc.pos.produto.eletronico.televisor;

import javax.inject.Inject;

import br.unisc.pos.infra.BaseService;

public class TelevisorService extends BaseService<Televisor, Long> {

    private static final long serialVersionUID = 1L;

    @Inject
    private TelevisorDAO televisorDAO;

    @Override
    public void initDAO() {
        super.setDAO(televisorDAO);
    }
}
