package com.dmx.app_notification.notification.domain;

import com.dmx.shared.kernel.Utils;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public final class NotificationInstant implements Serializable {
    private Timestamp value;

    public NotificationInstant(Timestamp value) {
        this.value = value;
    }

    private NotificationInstant() {
        value = null;
    }

    public static String dateToString(LocalDateTime dateTime) {
        return Utils.dateToString(dateTime);
    }

    public static String dateToString(Timestamp timestamp) {
        return Utils.dateToString(timestamp);
    }

    public static NotificationInstant now() {
        return new NotificationInstant(Timestamp.valueOf(LocalDateTime.now()));
    }

    public Timestamp value() {
        return value;
    }
}

