package com.dmx.social_graph.block.infrastructure.persistence;

import com.dmx.persistence.hibernate.HibernateRepository;
import com.dmx.shared.kernel.Service;
import com.dmx.shared.kernel.criteria.Criteria;
import com.dmx.shared.kernel.criteria.Filter;
import com.dmx.shared.kernel.criteria.Filters;
import com.dmx.shared.kernel.criteria.Order;
import com.dmx.social_graph.block.domain.Block;
import com.dmx.social_graph.block.domain.BlockRepository;
import com.dmx.social_graph.block.domain.UserId;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("social_graph-transaction_manager")
public class PostgreSQLBlockRepository extends HibernateRepository<Block> implements BlockRepository {

    public PostgreSQLBlockRepository(@Qualifier("social_graph-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Block.class);
    }

    @Override
    public void save(Block block) {
        persist(block);
    }

    @Override
    public void delete(Block block) {
        remove(block);
    }

    @Override
    public boolean existsByUsers(UserId userId, UserId blockedId) {
        Filters filters = new Filters(List.of(
                Filter.create("userId.value", "=", userId.value()),
                Filter.create("blockedId.value", "=", blockedId.value())
        ));
        Order order = Order.none();
        Criteria criteria = new Criteria(filters, order);
        return !byCriteria(criteria).isEmpty();
    }

    @Override
    public Optional<Block> findByUsers(UserId userId, UserId blockedId) {
        Filters filters = new Filters(List.of(
                Filter.create("userId.value", "=", userId.value()),
                Filter.create("blockedId.value", "=", blockedId.value())
        ));
        Order order = Order.none();
        Criteria criteria = new Criteria(filters, order);
        List<Block> block = byCriteria(criteria);
        return block.isEmpty() ? Optional.empty() : Optional.of(block.get(0));
    }
}
