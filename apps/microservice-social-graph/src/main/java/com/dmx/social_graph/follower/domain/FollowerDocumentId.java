package com.dmx.social_graph.follower.domain;

public final class FollowerDocumentId {
    public static String of(String userId, String followerId) {
        return userId + "_" + followerId;
    }
}
