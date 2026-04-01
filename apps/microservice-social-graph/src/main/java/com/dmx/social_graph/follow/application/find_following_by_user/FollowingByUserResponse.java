package com.dmx.social_graph.follow.application.find_following_by_user;

import com.dmx.bus.query.Response;
import com.dmx.social_graph.follow.domain.Follow;
import com.dmx.social_graph.follow.domain.FollowDTO;

import java.io.Serializable;
import java.util.List;

public final class FollowingByUserResponse implements Response, Serializable {
    private final List<FollowDTO> following;

    public FollowingByUserResponse(List<Follow> following) {
        this.following = following.stream().map(Follow::toPrimitives).toList();
    }

    public List<FollowDTO> getFollowing() {
        return following;
    }
}
