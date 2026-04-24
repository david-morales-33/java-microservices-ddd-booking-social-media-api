package com.dmx.profile.shared.infrastructure.persistence;

import com.dmx.infrastructure.persistence.hibernate.HibernateOutboxEventRepository;
import com.dmx.shared.kernel.Service;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.Transactional;

@Primary
@Service
@Transactional("user_profile-transaction_manager")
public class PostgresSQLOutboxEventRepository extends HibernateOutboxEventRepository {
    public PostgresSQLOutboxEventRepository(@Qualifier("profile-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
