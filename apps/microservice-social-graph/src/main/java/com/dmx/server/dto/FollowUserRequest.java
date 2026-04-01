package com.dmx.server.dto;

public record FollowUserRequest(
        String followerId,
        String followedId
) {
}
