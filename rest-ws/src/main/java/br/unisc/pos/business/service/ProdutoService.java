package br.unisc.pos.business.service;

import javax.inject.Inject;

import br.unisc.pos.business.dao.ProdutoDAO;
import br.unisc.pos.business.model.Produto;
import br.unisc.pos.infra.BaseService;

public class ProdutoService extends BaseService<Produto, Long> {

    private static final long serialVersionUID = 1L;

    @Inject
    private ProdutoDAO produtoDAO;

    @Override
    public void initDAO() {
        super.setDAO(produtoDAO);
    }
}
