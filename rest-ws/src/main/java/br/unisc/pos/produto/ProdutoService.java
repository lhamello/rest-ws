package br.unisc.pos.produto;

import javax.inject.Inject;

import br.unisc.pos.infra.BaseService;

public class ProdutoService extends BaseService<Produto, Long> {

    private static final long serialVersionUID = 1L;

    @Inject
    private LivroDAO produtoDAO;

    @Override
    public void initDAO() {
        super.setDAO(produtoDAO);
    }
}
