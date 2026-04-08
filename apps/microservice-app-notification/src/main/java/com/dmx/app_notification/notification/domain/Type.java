package com.dmx.app_notification.notification.domain;

public enum Type {
    BOOKING_CONFIRMED("BOOKING_CONFIRMED"),
    NEW_FOLLOWER("NEW_FOLLOWER"),
    NEW_MESSAGE("NEW_MESSAGE"),
    NEW_REVIEW("NEW_REVIEW"),
    NEW_LIKE("NEW_LIKE"),
    NEW_COMMENT("NEW_COMMENT");

    private final String value;

    Type(String value) {
        this.value = value;
    }

    public static Type fromValue(String value) {
        return switch (value) {
            case "BOOKING_CONFIRMED" -> Type.BOOKING_CONFIRMED;
            case "NEW_FOLLOWER" -> Type.NEW_FOLLOWER;
            case "NEW_MESSAGE" -> Type.NEW_MESSAGE;
            case "NEW_REVIEW" -> Type.NEW_REVIEW;
            case "NEW_LIKE" -> Type.NEW_LIKE;
            case "NEW_COMMENT" -> Type.NEW_COMMENT;
            default -> null;
        };
    }

    public String value() {
        return value;
    }
}
