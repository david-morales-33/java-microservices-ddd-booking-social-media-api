package com.dmx.profile.photo.domain;

public enum Type {
    COVER("cover"),
    AVATAR("avatar"),
    PROFILE("profile");

    private final String type;

    Type(String type) {
        this.type = type;
    }

    public boolean isCover() {
        return this == COVER;
    }
    public boolean isAvatar() {
        return this == AVATAR;
    }
    public boolean isProfile() {
        return this == PROFILE;
    }

    public String value() {
        return type;
    }
}
