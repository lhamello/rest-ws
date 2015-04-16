package br.unisc.pos.xxx;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;

public class GameDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @PersistenceContext(unitName = "EXAMPLE")
    private transient EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Game> listar(Game game) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Game.class);

        detachedCriteria.add(Example.create(game).enableLike(MatchMode.ANYWHERE).ignoreCase());

        detachedCriteria.addOrder(Order.asc(entityManager.unwrap(Session.class).getSessionFactory().getClassMetadata(Game.class).getIdentifierPropertyName()));

        final Criteria criteria = detachedCriteria.getExecutableCriteria(entityManager.unwrap(Session.class));

        return criteria.list();
    }
}
