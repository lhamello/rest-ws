package br.unisc.pos.produto.jogoeletronico;

import javax.inject.Inject;

import br.unisc.pos.infra.BaseService;

public class JogoEletronicoService extends BaseService<JogoEletronico, Long> {

    private static final long serialVersionUID = 1L;

    @Inject
    private JogoEletronicoDAO jogoEletronicoDAO;

    @Override
    public void initDAO() {
        super.setDAO(jogoEletronicoDAO);
    }
}
