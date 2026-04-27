package com.dmx.social_graph.user.domain;

import java.io.Serializable;
import java.util.HashMap;

public final class UserMapper {
    public static HashMap<String, Serializable> toPlainData(UserDTO user) {
        return new HashMap<>() {{
            put("id", user.id());
            put("name", user.name());
            put("nickname", user.nickname());
            put("photo", user.photo());
        }};
    }

    public static UserDTO toDTO(HashMap<String, Serializable> plainData) {
        return new UserDTO(
                (String) plainData.get("id"),
                (String) plainData.get("name"),
                (String) plainData.get("nickname"),
                (String) plainData.get("photo")
        );
    }
}
