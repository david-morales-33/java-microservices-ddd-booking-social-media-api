package com.dmx.social_graph.block.domain;

import com.dmx.shared.kernel.AggregateRoot;
import com.dmx.shared.kernel.Identifier;
import com.dmx.social_graph.shared.domain.events.BlockUserDomainEvent;

import java.text.DateFormat;
import java.util.Objects;

public final class Block extends AggregateRoot {
    private final BlockId blockId;
    private final UserId userId;
    private final UserId blockedId;
    private final BlockInstant createAt;

    public Block(BlockId blockId, UserId userId, UserId blockedId, BlockInstant createAt) {
        this.blockId = blockId;
        this.userId = userId;
        this.blockedId = blockedId;
        this.createAt = createAt;
    }

    public Block() {
        blockId = null;
        userId = null;
        blockedId = null;
        createAt = null;
    }

    public static Block create(BlockId blockId, UserId userId, UserId blockedId) {
        if (userId.equals(blockedId)) {
            throw new UserBlockThemselvesExcecption(userId);
        }
        Block block = new Block(blockId, userId, blockedId, BlockInstant.now());
        block.record(new BlockUserDomainEvent(blockId.value(), Identifier.generate(), DateFormat.getDateInstance().toString()));
        return block;
    }

    public BlockId getBlockId() {
        return blockId;
    }

    public UserId getUserId() {
        return userId;
    }

    public UserId getBlockedId() {
        return blockedId;
    }

    public BlockInstant getCreateAt() {
        return createAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return userId.equals(block.userId) && blockedId.equals(block.blockedId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, blockedId);
    }
}
