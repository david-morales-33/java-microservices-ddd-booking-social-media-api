package com.dmx.profile.user_profile.application.create_user_profile;

import com.dmx.profile.status.domain.Status;
import com.dmx.profile.user_profile.domain.*;
import com.dmx.shared.kernel.Service;

import java.util.Optional;

@Service
public final class UserProfileCreator {
    private final UserProfileRepository repository;
    private final UserProfileService service;

    public UserProfileCreator(UserProfileRepository repository, UserProfileService service) {
        this.repository = repository;
        this.service = service;
    }

    void execute(
            UserProfileId id,
            UserProfileName name,
            UserProfileNickname nickname,
            UserProfileEmail email,
            UserProfileAge age,
            UserProfileGender gender,
            UserProfileDescription description
    ) throws UserProfileAlreadyExistsException {

        Optional<UserProfile> response = this.repository.find(id);

        if (response.isPresent()) throw new UserProfileAlreadyExistsException(id);

        Optional<Status> statusService = service.findDefaultStatus();

        if (statusService.isEmpty()) throw new ResourceException();

        Status status = statusService.get();

        UserProfile profile = UserProfile.create(id, name, nickname, email, age, gender, description, status);

        this.repository.save(profile);
    }
}
