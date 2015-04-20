package br.unisc.pos.produto.eletronico.eletrodomestico;

import javax.inject.Inject;

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
