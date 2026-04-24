package com.dmx.social_graph.following.domain;

import java.io.Serializable;
import java.util.HashMap;

public final class FollowingMapper {
    public static HashMap<String, Serializable> toPlainData(FollowingDTO followingDTO) {
        return new HashMap<>() {{
            put("followingId", followingDTO.followingId());
            put("userId", followingDTO.userId());
            put("name", followingDTO.name());
            put("followOn", followingDTO.followOn());
            put("photo", followingDTO.photo());

        }};
    }

    public static FollowingDTO toDTO(HashMap<String, Serializable> plainData) {
        return new FollowingDTO(
                (String) plainData.get("followingId"),
                (String) plainData.get("userId"),
                (String) plainData.get("name"),
                (String) plainData.get("followOn"),
                (String) plainData.get("photo")
        );
    }

    public static String id(FollowingDTO following) {
        return FollowingDocumentId.of(following.userId(), following.followingId());
    }
}
