package com.dmx.social_graph.follow.application.find_followers_by_user;

import com.dmx.bus.query.Response;
import com.dmx.social_graph.follow.domain.Follow;
import com.dmx.social_graph.follow.domain.FollowDTO;

import java.io.Serializable;
import java.util.List;

public final class FollowerByUserResponse implements Response, Serializable {
    private final List<FollowDTO> followers;

    public FollowerByUserResponse(List<Follow> followers) {
        this.followers = followers.stream().map(Follow::toPrimitives).toList();
    }

    public List<FollowDTO> getFollowers() {
        return followers;
    }
}
