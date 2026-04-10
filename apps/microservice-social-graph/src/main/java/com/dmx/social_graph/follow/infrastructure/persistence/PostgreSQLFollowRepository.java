package com.dmx.social_graph.follow.infrastructure.persistence;

import com.dmx.infrastructure.persistence.hibernate.HibernateRepository;
import com.dmx.shared.kernel.Service;
import com.dmx.shared.kernel.criteria.Criteria;
import com.dmx.shared.kernel.criteria.Filter;
import com.dmx.shared.kernel.criteria.Filters;
import com.dmx.shared.kernel.criteria.Order;
import com.dmx.social_graph.follow.domain.Follow;
import com.dmx.social_graph.follow.domain.FollowRepository;
import com.dmx.social_graph.follow.domain.UserId;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("social_graph-transaction_manager")
public class PostgreSQLFollowRepository extends HibernateRepository<Follow> implements FollowRepository {

    public PostgreSQLFollowRepository(@Qualifier("social_graph-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Follow.class);
    }

    @Override
    public void save(Follow follow) {
        persist(follow);
    }

    @Override
    public void delete(Follow follow) {
        remove(follow);
    }

    @Override
    public boolean existsActiveFollow(UserId followerId, UserId userId) {
        Filters filters = new Filters(List.of(
                Filter.create("userId.value", "=", userId.value()),
                Filter.create("followerId.value", "=", followerId.value())
        ));
        Order order = Order.none();
        Criteria criteria = new Criteria(filters, order);
        return !byCriteria(criteria).isEmpty();
    }

    @Override
    public Optional<Follow> findByUsers(UserId userId, UserId followerId) {
        Filters filters = new Filters(List.of(Filter.create("userId.value", "=", userId.value())));
        Order order = Order.none();
        Criteria criteria = new Criteria(filters, order);
        List<Follow> follow = byCriteria(criteria);
        return follow.isEmpty() ? Optional.empty() : Optional.of(follow.get(0));
    }

    @Override
    public List<Follow> findFollowersOf(UserId userId) {
        Filters filters = new Filters(List.of(Filter.create("userId.value", "=", userId.value())));
        Order order = Order.none();
        Criteria criteria = new Criteria(filters, order);
        return byCriteria(criteria);
    }

    @Override
    public List<Follow> findFollowingOf(UserId userId) {
        Filters filters = new Filters(List.of(Filter.create("followerId.value", "=", userId.value())));
        Order order = Order.none();
        Criteria criteria = new Criteria(filters, order);
        return byCriteria(criteria);
    }
}
