package com.dmx.profile.user_profile.application.find;

import com.dmx.bus.query.QueryHandler;
import com.dmx.profile.user_profile.domain.UserProfileId;
import com.dmx.profile.user_profile.domain.UserProfileNotFoundException;
import com.dmx.shared.kernel.Service;

@Service
public final class FindUserProfileQueryHandler implements QueryHandler<FindUserProfileQuery, UserProfileResponse> {

    private final UserProfileFinder finder;

    public FindUserProfileQueryHandler(UserProfileFinder finder) {
        this.finder = finder;
    }

    @Override
    public UserProfileResponse handle(FindUserProfileQuery query) throws UserProfileNotFoundException {
        UserProfileId id = new UserProfileId(query.id());
        return this.finder.execute(id);
    }
}
