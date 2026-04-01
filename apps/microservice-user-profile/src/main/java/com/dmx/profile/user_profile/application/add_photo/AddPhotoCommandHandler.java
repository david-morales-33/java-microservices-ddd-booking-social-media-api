package com.dmx.profile.user_profile.application.add_photo;

import com.dmx.bus.command.CommandHandler;
import com.dmx.profile.photo.domain.PhotoType;
import com.dmx.profile.photo.domain.PhotoUrl;
import com.dmx.profile.user_profile.domain.UserProfileId;
import com.dmx.shared.kernel.Service;

@Service
public final class AddPhotoCommandHandler implements CommandHandler<AddPhotoCommand> {

    private final PhotoCreator creator;

    public AddPhotoCommandHandler(PhotoCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(AddPhotoCommand command) {
        UserProfileId userId = new UserProfileId(command.getUserProfileId());
        PhotoUrl url = new PhotoUrl(command.getPhotoUrl());
        PhotoType type = new PhotoType(command.getPhotoType());
        creator.execute(userId, url, type);
    }
}
