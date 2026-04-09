package com.dmx.app_notification.notification.infrastructure.persistence;

import com.dmx.app_notification.notification.domain.Notification;
import com.dmx.app_notification.notification.domain.NotificationId;
import com.dmx.app_notification.notification.domain.NotificationRepository;
import com.dmx.app_notification.notification.domain.UserId;
import com.dmx.persistence.hibernate.HibernateRepository;
import com.dmx.shared.kernel.Service;
import com.dmx.shared.kernel.criteria.Criteria;
import com.dmx.shared.kernel.criteria.Filter;
import com.dmx.shared.kernel.criteria.Filters;
import com.dmx.shared.kernel.criteria.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("app_notification-transaction_manager")
public class PostgresSQLNotificationRepository extends HibernateRepository<Notification> implements NotificationRepository {

    public PostgresSQLNotificationRepository(@Qualifier("app_notification-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Notification.class);
    }

    @Override
    public void save(Notification notification) {
        persist(notification);
    }

    @Override
    public Optional<Notification> find(NotificationId notificationId) {
        return byId(notificationId);
    }

    @Override
    public List<Notification> search(UserId id) {
        Filters filters = new Filters(List.of(
                Filter.create("recipientUserId.value", "=", id.value())
        ));
        Order order = Order.none();
        Criteria criteria = new Criteria(filters, order);
        return byCriteria(criteria);
    }
}
