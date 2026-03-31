package com.dmx.shared.kernel.domain.bus.query;

public interface QueryBus {
    <R> R ask(Query query) throws QueryHandlerExecutionException;
}
