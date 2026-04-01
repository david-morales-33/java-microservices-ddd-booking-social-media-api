package com.dmx.social_graph.follow.domain;

import com.dmx.shared.kernel.DomainException;

public class ReactiveException extends DomainException {
    public ReactiveException() {
        super("REACTIVE_EXCEPTION", "Reactive operation failed");
    }
}
