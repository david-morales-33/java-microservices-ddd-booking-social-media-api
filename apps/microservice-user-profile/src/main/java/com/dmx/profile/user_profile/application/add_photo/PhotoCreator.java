package com.dmx.profile.user_profile.application.add_photo;

import com.dmx.profile.photo.domain.Photo;
import com.dmx.profile.photo.domain.PhotoId;
import com.dmx.profile.photo.domain.PhotoType;
import com.dmx.profile.photo.domain.PhotoUrl;
import com.dmx.profile.user_profile.domain.UserProfile;
import com.dmx.profile.user_profile.domain.UserProfileId;
import com.dmx.profile.user_profile.domain.UserProfileNotFoundException;
import com.dmx.profile.user_profile.domain.UserProfileRepository;
import com.dmx.shared.kernel.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class PhotoCreator {
    private final UserProfileRepository repository;

    public PhotoCreator(UserProfileRepository repository) {
        this.repository = repository;
    }

    @Transactional("profile-transaction_manager")
    public void execute(UserProfileId userId, PhotoUrl url, PhotoType type) {
        Optional<UserProfile> response = repository.find(userId);

        if (response.isEmpty())
            throw new UserProfileNotFoundException(userId);

        UserProfile user = response.get();

        Photo photo = new Photo(new PhotoId(UUID.randomUUID().toString()), url, type);

        user.addPhotos(photo);
        repository.save(user);
    }
}
