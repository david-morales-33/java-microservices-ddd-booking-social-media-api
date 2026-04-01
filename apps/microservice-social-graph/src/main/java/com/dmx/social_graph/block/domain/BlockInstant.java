package com.dmx.social_graph.block.domain;

import com.dmx.shared.kernel.Utils;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public final class BlockInstant implements Serializable {
    private Timestamp value;

    public BlockInstant(Timestamp value) {
        this.value = value;
    }

    public BlockInstant() {
        value = null;
    }

    public static String dateToString(LocalDateTime dateTime) {
        return Utils.dateToString(dateTime);
    }

    public static String dateToString(Timestamp timestamp) {
        return Utils.dateToString(timestamp);
    }

    public static BlockInstant now() {
        return new BlockInstant(Timestamp.valueOf(LocalDateTime.now()));
    }
}
