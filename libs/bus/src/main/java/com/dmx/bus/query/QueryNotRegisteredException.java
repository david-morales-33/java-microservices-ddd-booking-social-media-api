package com.dmx.bus.query;

public final class QueryNotRegisteredException extends RuntimeException {
    public QueryNotRegisteredException(Class<? extends Query> query) {
        super(String.format("The command <%s> hasn't a command handler associated", query.toString()));

    }
}
