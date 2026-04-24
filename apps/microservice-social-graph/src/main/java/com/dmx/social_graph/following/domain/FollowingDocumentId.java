package com.dmx.social_graph.following.domain;

public final class FollowingDocumentId {
    public static String of(String userId, String followerId) {
        return userId + "_" + followerId;
    }
}
