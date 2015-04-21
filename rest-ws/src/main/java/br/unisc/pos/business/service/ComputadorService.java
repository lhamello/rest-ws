package br.unisc.pos.business.service;

import javax.inject.Inject;

import br.unisc.pos.business.dao.ComputadorDAO;
import br.unisc.pos.business.model.Computador;
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
