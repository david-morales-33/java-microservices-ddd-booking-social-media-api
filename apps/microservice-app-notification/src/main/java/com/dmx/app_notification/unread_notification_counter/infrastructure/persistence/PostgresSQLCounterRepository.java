package com.dmx.app_notification.unread_notification_counter.infrastructure.persistence;

import com.dmx.app_notification.notification.domain.UserId;
import com.dmx.app_notification.unread_notification_counter.domain.UnreadNotificationCounter;
import com.dmx.app_notification.unread_notification_counter.domain.UnreadNotificationCounterRepository;
import com.dmx.infrastructure.persistence.hibernate.HibernateRepository;
import com.dmx.shared.kernel.Service;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional("app_notification-transaction-manager")
public class PostgresSQLCounterRepository extends HibernateRepository<UnreadNotificationCounter> implements UnreadNotificationCounterRepository {

    public PostgresSQLCounterRepository(@Qualifier("app_notification-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, UnreadNotificationCounter.class);
    }

    @Override
    public void save(UnreadNotificationCounter counter) {
        persist(counter);
    }

    @Override
    public Optional<UnreadNotificationCounter> find(UserId userId) {
        return byId(userId);
    }
}
