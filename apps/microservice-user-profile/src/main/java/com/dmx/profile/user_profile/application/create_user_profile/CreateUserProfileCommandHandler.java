package com.dmx.profile.user_profile.application.create_user_profile;

import com.dmx.bus.command.CommandHandler;
import com.dmx.profile.user_profile.domain.*;
import com.dmx.shared.kernel.Service;

@Service
public final class CreateUserProfileCommandHandler implements CommandHandler<CreateUserProfileCommand> {

    private final UserProfileCreator creator;

    public CreateUserProfileCommandHandler(UserProfileCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateUserProfileCommand command) {

        UserProfileId id = new UserProfileId(command.getId());
        UserProfileName name = new UserProfileName(command.getName());
        UserProfileNickname nickname = new UserProfileNickname(command.getNickname());
        UserProfileAge age = new UserProfileAge(command.getAge());
        UserProfileEmail email = new UserProfileEmail(command.getEmail());
        UserProfileGender gender = new UserProfileGender(command.getGender());
        UserProfileDescription description = new UserProfileDescription(command.getDescription());

        this.creator.execute(id, name, nickname, email, age, gender,description);
    }
}
