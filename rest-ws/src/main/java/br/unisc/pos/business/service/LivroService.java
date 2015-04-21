package br.unisc.pos.business.service;

import javax.inject.Inject;

import br.unisc.pos.business.dao.LivroDAO;
import br.unisc.pos.business.model.Livro;
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
