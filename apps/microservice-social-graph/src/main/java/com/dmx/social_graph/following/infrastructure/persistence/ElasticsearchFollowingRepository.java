package com.dmx.social_graph.following.infrastructure.persistence;

import com.dmx.infrastructure.persistence.elasticsearch.ElasticsearchClientAdapter;
import com.dmx.infrastructure.persistence.elasticsearch.ElasticsearchRepository;
import com.dmx.shared.kernel.Service;
import com.dmx.shared.kernel.criteria.Criteria;
import com.dmx.social_graph.following.domain.FollowingDTO;
import com.dmx.social_graph.following.domain.FollowingMapper;
import com.dmx.social_graph.following.domain.FollowingRepository;

import java.util.List;

@Service
public class ElasticsearchFollowingRepository extends ElasticsearchRepository<FollowingDTO> implements FollowingRepository {
    public ElasticsearchFollowingRepository(ElasticsearchClientAdapter client) {
        super(client);
    }

    @Override
    protected String moduleName() {
        return "following";
    }

    @Override
    public void save(FollowingDTO follower) {
        persist(FollowingMapper.id(follower), FollowingMapper.toPlainData(follower));
    }

    @Override
    public List<FollowingDTO> find(String userId, int limit, int offset) {
        return List.of();
    }

    @Override
    public List<FollowingDTO> matching(Criteria criteria) {
        return List.of();
    }
}
