package com.dmx.profile.user_profile.domain;

import com.dmx.shared.kernel.DomainException;

public class RoleAlreadyExistException extends DomainException {
    public RoleAlreadyExistException(String message) {
        super("ROLE_ALREADY_EXITS",message);
    }
}
