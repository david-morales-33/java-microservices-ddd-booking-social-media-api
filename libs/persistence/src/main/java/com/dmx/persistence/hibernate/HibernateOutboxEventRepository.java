package com.dmx.persistence.hibernate;

import com.dmx.shared.kernel.events.OutboxEvent;
import com.dmx.shared.kernel.events.OutboxEventRepository;
import jakarta.persistence.LockModeType;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class HibernateOutboxEventRepository implements OutboxEventRepository {
    protected final SessionFactory sessionFactory;
    private final Integer ELEMENTS = 10;

    public HibernateOutboxEventRepository(SessionFactory sessionFactory) {
       this.sessionFactory= sessionFactory;
    }

    @Override
    public void save(OutboxEvent event) {
        sessionFactory.getCurrentSession().persist(event);
    }

    @Override
    public List<OutboxEvent> findUnpublished() {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<OutboxEvent> query = builder.createQuery(OutboxEvent.class);
        Root<OutboxEvent> root = query.from(OutboxEvent.class);
        query.orderBy(builder.asc(root.get("occurredOn")));
        query.select(root);

        return sessionFactory
                .getCurrentSession()
                .createQuery(query)
                .setMaxResults(ELEMENTS)
                .setFirstResult(0)
                .setLockMode(LockModeType.PESSIMISTIC_WRITE)
                .getResultList();
    }
}
