package br.unisc.pos.business.service;

import javax.inject.Inject;

import br.unisc.pos.business.dao.EletrodomesticoDAO;
import br.unisc.pos.business.model.Eletrodomestico;
import br.unisc.pos.infra.BaseService;

public class EletrodomesticoService extends BaseService<Eletrodomestico, Long> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EletrodomesticoDAO eletrodomesticoDAO;

    @Override
    public void initDAO() {
        super.setDAO(eletrodomesticoDAO);
    }
}
