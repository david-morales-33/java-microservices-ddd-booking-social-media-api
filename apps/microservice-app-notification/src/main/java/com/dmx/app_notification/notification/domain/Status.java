package com.dmx.app_notification.notification.domain;

public enum Status {
    READ("READ"),
    UNREAD("UNREAD");

    public final String value;

    Status(String value) {
        this.value = value;
    }
    public static Status fromValue(String value) {
        return switch (value) {
            case "READ" -> Status.READ;
            case "UNREAD" -> Status.UNREAD;
            default -> null;
        };
    }

    public String value() {
        return value;
    }
}
