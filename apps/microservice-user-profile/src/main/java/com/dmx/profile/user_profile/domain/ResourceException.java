package com.dmx.profile.user_profile.domain;

import com.dmx.shared.kernel.DomainException;

public class ResourceException extends DomainException {
    public ResourceException() {
        super("RESOURCES_FAILED", "The resources were not created correctly");
    }
}
