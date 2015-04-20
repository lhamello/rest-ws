package br.unisc.pos.produto.livro;

import javax.inject.Inject;

import br.unisc.pos.infra.BaseService;

public class LivroService extends BaseService<Livro, Long> {

    private static final long serialVersionUID = 1L;

    @Inject
    private LivroDAO livroDAO;

    @Override
    public void initDAO() {
        super.setDAO(livroDAO);
    }
}
