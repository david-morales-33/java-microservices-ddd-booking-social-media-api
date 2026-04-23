package com.dmx.social_graph.follower.domain;

import com.dmx.shared.kernel.criteria.Criteria;

import java.util.List;

public interface FollowerRepository {
    void save(FollowerDTO follower);

    List<FollowerDTO> find(String userId, int limit, int offset);

    List<FollowerDTO> matching(Criteria criteria);
}
