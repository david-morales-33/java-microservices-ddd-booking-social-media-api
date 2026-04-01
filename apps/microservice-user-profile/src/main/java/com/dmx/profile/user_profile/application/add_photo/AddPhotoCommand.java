package com.dmx.profile.user_profile.application.add_photo;

import com.dmx.bus.command.Command;

public final class AddPhotoCommand implements Command {

    private final String UserProfileId;
    private final String photoUrl;
    private final String photoType;

    public AddPhotoCommand(String userProfileId, String photoUrl, String photoType) {
        UserProfileId = userProfileId;
        this.photoUrl = photoUrl;
        this.photoType = photoType;
    }

    public String getUserProfileId() {
        return UserProfileId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getPhotoType() {
        return photoType;
    }
}
