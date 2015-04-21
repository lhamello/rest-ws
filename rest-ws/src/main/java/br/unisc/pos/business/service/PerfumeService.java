package br.unisc.pos.business.service;

import javax.inject.Inject;

import br.unisc.pos.business.dao.PerfumeDAO;
import br.unisc.pos.business.model.Perfume;
import br.unisc.pos.infra.BaseService;

public class PerfumeService extends BaseService<Perfume, Long> {

    private static final long serialVersionUID = 1L;

    @Inject
    private PerfumeDAO perfumeDAO;

    @Override
    public void initDAO() {
        super.setDAO(perfumeDAO);
    }
}
