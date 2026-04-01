package com.dmx.social_graph.follow.domain;

import java.io.Serializable;

public record FollowDTO(
        String id,
        String userId,
        String followerId,
        String createdAt
) implements Serializable {

}
