package com.dmx.profile.user_profile.domain;

import com.dmx.shared.kernel.DomainException;

public class AgeNotValidException extends DomainException {
  public AgeNotValidException(String message) {
    super("AGE_NOT_VALID",message);
  }
}
