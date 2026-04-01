package com.dmx.social_graph.block.domain;

import java.util.Optional;

public interface BlockRepository {
    void save(Block block);

    void delete(Block block);

    boolean existsByUsers(UserId userId, UserId blockedId);

    Optional<Block> findByUsers(UserId userId, UserId blockedId);
}
