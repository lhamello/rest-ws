package br.unisc.pos.produto.perfume;

import javax.inject.Inject;

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
