package com.dmx.social_graph.stats.infrastructure.persistence;

import com.dmx.shared.kernel.Service;
import com.dmx.social_graph.stats.domain.Stats;
import com.dmx.social_graph.stats.domain.StatsRepository;
import com.dmx.social_graph.stats.domain.UserId;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional("social_graph-transaction_manager")
public class PostgresSQLStatsRepository implements StatsRepository {
    protected final SessionFactory sessionFactory;

    public PostgresSQLStatsRepository(@Qualifier("social_graph-session_factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Stats stats) {
        sessionFactory.getCurrentSession().persist(stats);
    }

    @Override
    public Optional<Stats> find(UserId id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(Stats.class).load(id));
    }
}
