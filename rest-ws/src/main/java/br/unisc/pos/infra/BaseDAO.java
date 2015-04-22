package br.unisc.pos.infra;

import java.lang.reflect.ParameterizedType;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class BaseDAO<E extends BaseEntity<K>, K> {

    @PersistenceContext
    protected transient EntityManager entityManager;
    private final transient Class<E> entityClass;

    @SuppressWarnings("unchecked")
    public BaseDAO() {
        final ParameterizedType superClass = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) superClass.getActualTypeArguments()[0];
    }

    public DetachedCriteria adicionarRestricoes(DetachedCriteria detachedCriteria, final E entity) {
        detachedCriteria.add(Example.create(entity).enableLike(MatchMode.ANYWHERE).ignoreCase());
        return detachedCriteria;
    }

    @SuppressWarnings("unchecked")
    public List<E> listar(final E entity) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(entityClass);

        detachedCriteria = this.adicionarRestricoes(detachedCriteria, entity);

        this.adicionarOrdem(entity, detachedCriteria);

        final Criteria criteria = detachedCriteria.getExecutableCriteria(entityManager.unwrap(Session.class));

        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public E consultarPorNamedQuery(final K primaryKey) {
        final String namedQuery = this.criarNamedQuery("findById");

        final Query query = entityManager.createNamedQuery(namedQuery);
        query.setParameter("pk", primaryKey);

        return (E) query.getSingleResult();
    }

    public E incluir(final E entity) {
        entity.setDataHoraInclusao(Calendar.getInstance().getTime());
        
        entityManager.persist(entity);
        entityManager.flush();

        return entity;
    }

    public E alterar(final E entity) {
        entity.setDataHoraUltimaAlteracao(Calendar.getInstance().getTime());
        
        entityManager.merge(entity);
        entityManager.flush();

        return entity;
    }

    public void excluir(final E entity) {
        entityManager.remove(entity);
        entityManager.flush();
    }

    public void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public long contar(final E entity) {
        final DetachedCriteria detachedCriteria = DetachedCriteria.forClass(entityClass);
        detachedCriteria.add(Example.create(entity).enableLike(MatchMode.ANYWHERE).ignoreCase());

        final Criteria criteria = detachedCriteria.getExecutableCriteria(entityManager.unwrap(Session.class));
        criteria.setProjection(Projections.count(entityManager.unwrap(Session.class).getSessionFactory().getClassMetadata(entityClass).getIdentifierPropertyName()));

        Long result = (Long) criteria.uniqueResult();
        return result.longValue();
    }

    private String criarNamedQuery(final String querySuffix) {
        final StringBuilder namedQuery = new StringBuilder();
        namedQuery.append(entityClass.getSimpleName()).append(".").append(querySuffix);

        return namedQuery.toString();
    }

    public void adicionarOrdem(E entity, DetachedCriteria detachedCriteria) {
        detachedCriteria.addOrder(Order.asc(entityManager.unwrap(Session.class).getSessionFactory().getClassMetadata(entityClass).getIdentifierPropertyName()));
    }

    public DetachedCriteria criarCriterioDesatachado() {
        return DetachedCriteria.forClass(entityClass);
    }

    public Criteria criarCriterio() {
        return this.criarCriterioDesatachado().getExecutableCriteria(entityManager.unwrap(Session.class));
    }

    @SuppressWarnings("unchecked")
    public E consultarChave(K pk) {
        final Criteria crit = this.criarCriterio();
        crit.add(Restrictions.idEq(pk));
        return (E) crit.uniqueResult();
    }
}
