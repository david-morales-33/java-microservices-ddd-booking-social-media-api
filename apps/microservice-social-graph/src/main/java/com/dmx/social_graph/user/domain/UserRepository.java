package com.dmx.social_graph.user.domain;

import java.util.Optional;

public interface UserRepository {
    void save(UserDTO user);

    Optional<UserDTO> find(String id);

    boolean existsUser(String id);
}
