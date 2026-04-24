package com.dmx.social_graph.following.domain;

import com.dmx.shared.kernel.criteria.Criteria;
import com.dmx.social_graph.follower.domain.FollowerDTO;

import java.util.List;

public interface FollowingRepository {
    void save(FollowingDTO follower);

    List<FollowingDTO> find(String userId, int limit, int offset);

    List<FollowingDTO> matching(Criteria criteria);
}
