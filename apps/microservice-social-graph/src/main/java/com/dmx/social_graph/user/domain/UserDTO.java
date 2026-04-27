package com.dmx.social_graph.user.domain;

import java.io.Serializable;

public record UserDTO(String id, String name, String nickname, String photo) implements Serializable {
}
