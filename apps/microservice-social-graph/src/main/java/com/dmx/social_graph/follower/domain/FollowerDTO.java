package com.dmx.social_graph.follower.domain;

import java.io.Serializable;

public record FollowerDTO(
        String userId,
        String followerId,
        String name,
        String followOn,
        String photo) implements Serializable {
}
