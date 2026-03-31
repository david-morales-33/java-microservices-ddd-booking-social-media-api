package com.dmx.shared.kernel.domain.bus.query;

public interface QueryHandler<Q extends Query, R extends Response> {
    R handle(Q query);
}
