package com.dmx.social_graph.follower.domain;

import java.io.Serializable;
import java.util.HashMap;

public final class FollowerMapper {
    public static HashMap<String, Serializable> toPlainData(FollowerDTO followerDTO) {
        return new HashMap<>() {{
            put("followerId", followerDTO.followerId());
            put("userId", followerDTO.userId());
            put("name", followerDTO.name());
            put("followOn", followerDTO.followOn());
            put("photo", followerDTO.photo());

        }};
    }
    public static FollowerDTO toDTO(HashMap<String, Serializable> plainData) {
        return new FollowerDTO(
                (String) plainData.get("followerId"),
                (String) plainData.get("userId"),
                (String) plainData.get("name"),
                (String) plainData.get("followOn"),
                (String) plainData.get("photo")
        );
    }
}
