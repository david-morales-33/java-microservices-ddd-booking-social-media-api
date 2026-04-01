package com.dmx.profile.user_profile.application.find;

import com.dmx.bus.query.Query;

public final class FindUserProfileQuery implements Query {
    private final String id;

    public FindUserProfileQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
