package com.dmx.social_graph.shared.infrastructure.persistence;

import com.dmx.persistence.hibernate.HibernateOutboxEventRepository;
import com.dmx.shared.kernel.Service;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.Transactional;

@Primary
@Service
@Transactional("social_graph-transaction_manager")
public class PostgresSQLOutboxEventRepository extends HibernateOutboxEventRepository{
    public PostgresSQLOutboxEventRepository(@Qualifier("social_graph-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
