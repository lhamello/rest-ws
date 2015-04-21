package br.unisc.pos.infra;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

public abstract class BaseService<E extends BaseEntity<K>, K> implements Serializable {

    private static final long serialVersionUID = 1L;
    private transient BaseDAO<E, K> dao;

    @PostConstruct
    public abstract void initDAO();

    public List<E> listar(final E entity) {
        return dao.listar(entity);
    }

    public E incluir(final E entity) {
        if (entity.getId() != null) {
            throw new IdNotNullException("O ID do objeto deve ser nulo.");
        }

        return dao.incluir(entity);
    }

    public E alterar(final E entity) {
        return dao.alterar(entity);
    }

    public long contar(final E entity) {
        return dao.contar(entity);
    }

    public void excluir(final E entity) {
        dao.excluir(entity);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void setDAO(final BaseDAO dao) {
        this.dao = dao;
    }

    public E consultarChave(K pk) {
        return (E) dao.consultarChave(pk);
    }
}
