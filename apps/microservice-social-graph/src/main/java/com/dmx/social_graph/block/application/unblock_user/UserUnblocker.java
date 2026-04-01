package com.dmx.social_graph.block.application.unblock_user;

import com.dmx.shared.kernel.Service;
import com.dmx.social_graph.block.domain.*;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserUnblocker {
    private final BlockRepository repository;

    public UserUnblocker(BlockRepository repository) {
        this.repository = repository;
    }

    @Transactional("social_graph-transaction_manager")
    public void execute(UserId userId, UserId blockedId) {
        if (!repository.existsByUsers(userId, blockedId)) {
            throw new UserBlockNotAllowedException();
        }
        Block block = repository.findByUsers(userId, blockedId).orElseThrow();
        repository.delete(block);
    }
}
