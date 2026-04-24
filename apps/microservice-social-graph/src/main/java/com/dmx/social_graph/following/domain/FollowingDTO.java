package com.dmx.social_graph.following.domain;

public record FollowingDTO(
        String userId,
        String followingId,
        String name,
        String followOn,
        String photo
) {
}
