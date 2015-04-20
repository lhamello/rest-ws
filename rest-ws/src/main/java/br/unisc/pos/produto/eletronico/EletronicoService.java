package br.unisc.pos.produto.eletronico;

import javax.inject.Inject;

import br.unisc.pos.infra.BaseService;

public class EletronicoService extends BaseService<Eletronico, Long> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EletronicoDAO eletronicoDAO;

    @Override
    public void initDAO() {
        super.setDAO(eletronicoDAO);
    }
}
