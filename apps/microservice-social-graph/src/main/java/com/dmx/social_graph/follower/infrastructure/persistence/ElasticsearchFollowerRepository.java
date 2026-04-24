package com.dmx.social_graph.follower.infrastructure.persistence;

import com.dmx.infrastructure.persistence.elasticsearch.ElasticsearchClientAdapter;
import com.dmx.infrastructure.persistence.elasticsearch.ElasticsearchRepository;
import com.dmx.shared.kernel.Service;
import com.dmx.shared.kernel.criteria.Criteria;
import com.dmx.social_graph.follower.domain.FollowerDTO;
import com.dmx.social_graph.follower.domain.FollowerMapper;
import com.dmx.social_graph.follower.domain.FollowerRepository;

import java.util.List;

@Service
public class ElasticsearchFollowerRepository extends ElasticsearchRepository<FollowerDTO> implements FollowerRepository {
    public ElasticsearchFollowerRepository(ElasticsearchClientAdapter client) {
        super(client);
    }

    @Override
    protected String moduleName() {
        return "follower";
    }

    @Override
    public void save(FollowerDTO follower) {
        persist(FollowerMapper.id(follower), FollowerMapper.toPlainData(follower));
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
