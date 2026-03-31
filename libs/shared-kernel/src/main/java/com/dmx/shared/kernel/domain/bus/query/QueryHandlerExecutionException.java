package com.dmx.shared.kernel.domain.bus.query;

public final class QueryHandlerExecutionException extends RuntimeException {
    public QueryHandlerExecutionException(Throwable message) {
        super(message);
    }
}
