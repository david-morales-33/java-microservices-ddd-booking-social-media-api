package com.dmx.social_graph.user.domain;

public interface UserRepository {
    void save(UserDTO user);

    UserDTO findById(String id);

    boolean existsUser(String id);
}
