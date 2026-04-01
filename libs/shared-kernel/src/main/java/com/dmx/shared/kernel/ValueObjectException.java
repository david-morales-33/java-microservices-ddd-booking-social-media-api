package com.dmx.shared.kernel;

public class ValueObjectException extends DomainException {
    public ValueObjectException(String message) {
        super("VALUE_ERROR", message);
    }
}
