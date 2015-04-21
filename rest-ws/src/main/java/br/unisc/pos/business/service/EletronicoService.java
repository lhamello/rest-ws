package br.unisc.pos.business.service;

import javax.inject.Inject;

import br.unisc.pos.business.dao.EletronicoDAO;
import br.unisc.pos.business.model.Eletronico;
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
