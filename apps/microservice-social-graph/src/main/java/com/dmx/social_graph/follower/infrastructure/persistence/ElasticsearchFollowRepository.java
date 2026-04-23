package com.dmx.social_graph.follower.infrastructure.persistence;

import com.dmx.infrastructure.persistence.elasticsearch.ElasticsearchClientAdapter;
import com.dmx.infrastructure.persistence.elasticsearch.ElasticsearchRepository;
import com.dmx.shared.kernel.Service;
import com.dmx.shared.kernel.criteria.Criteria;
import com.dmx.social_graph.follower.domain.FollowerDTO;
import com.dmx.social_graph.follower.domain.FollowerMapper;
import com.dmx.social_graph.follower.domain.FollowerRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional("social_graph-transaction_manager")
public class ElasticsearchFollowRepository extends ElasticsearchRepository<FollowerDTO> implements FollowerRepository {
    public ElasticsearchFollowRepository(ElasticsearchClientAdapter client) {
        super(client);
    }

    @Override
    protected String moduleName() {
        return "follower";
    }

    @Override
    public void save(FollowerDTO follower) {
        persist(follower.followerId(), FollowerMapper.toPlainData(follower));
    }

    @Override
    public List<FollowerDTO> find(String userId, int limit, int offset) {
        return List.of();
    }

    @Override
    public List<FollowerDTO> matching(Criteria criteria) {
        return List.of();
    }
}
