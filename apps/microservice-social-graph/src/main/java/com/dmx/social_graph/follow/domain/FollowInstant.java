package com.dmx.social_graph.follow.domain;

import com.dmx.shared.kernel.Utils;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class FollowInstant implements Serializable {
    private Timestamp value;

    public FollowInstant(Timestamp value) {
        this.value = value;
    }

    private FollowInstant() {
        value = null;
    }

    public static String dateToString(LocalDateTime dateTime) {
        return Utils.dateToString(dateTime);
    }

    public static String dateToString(Timestamp timestamp) {
        return Utils.dateToString(timestamp);
    }

    public static FollowInstant now() {
        return new FollowInstant(Timestamp.valueOf(LocalDateTime.now()));
    }

    public Timestamp value() {
        return value;
    }
}
