package com.dmx.social_graph.block.application.block_user;

import com.dmx.shared.kernel.Service;
import com.dmx.social_graph.block.domain.*;
import com.dmx.social_graph.follow.domain.FollowRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserBlocker {
    private final BlockRepository blockRepository;
    private final FollowRepository followRepository;

    public UserBlocker(BlockRepository blockRepository, FollowRepository followRepository) {
        this.blockRepository = blockRepository;
        this.followRepository = followRepository;
    }

    @Transactional("social_graph-transaction_manager")
    public void execute(UserId userId, UserId blockedId) {

        if (this.blockRepository.existsByUsers(userId, blockedId)) {
            throw new UserBlockNotAllowedException();
        }

        BlockId blockId = new BlockId(BlockId.generate());
        Block newBlock = Block.create(blockId, userId, blockedId);

        this.followRepository.findByUsers( // delete follow if exists from user to blocked
                new com.dmx.social_graph.follow.domain.UserId(userId.value()),
                new com.dmx.social_graph.follow.domain.UserId(blockedId.value())
        ).ifPresent(this.followRepository::delete);

        this.followRepository.findByUsers( // delete follow if exists from blocked to user
                new com.dmx.social_graph.follow.domain.UserId(blockedId.value()),
                new com.dmx.social_graph.follow.domain.UserId(userId.value())
        ).ifPresent(this.followRepository::delete);

        this.blockRepository.save(newBlock);
    }
}
