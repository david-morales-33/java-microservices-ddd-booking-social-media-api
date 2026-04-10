package com.dmx.infrastructure.spring;

import com.dmx.bus.command.Command;
import com.dmx.bus.command.CommandBus;
import com.dmx.bus.command.CommandHandlerExecutionException;
import com.dmx.bus.query.Query;
import com.dmx.bus.query.QueryBus;
import com.dmx.bus.query.QueryHandlerExecutionException;
import com.dmx.shared.kernel.DomainException;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

public abstract class ApiController {
    private final QueryBus queryBus;
    private final CommandBus commandBus;

    public ApiController(QueryBus queryBus, CommandBus commandBus) {
        this.queryBus   = queryBus;
        this.commandBus = commandBus;
    }

    protected void dispatch(Command command) throws CommandHandlerExecutionException {
        commandBus.dispatch(command);
    }

    protected <R> R ask(Query query) throws QueryHandlerExecutionException {
        return queryBus.ask(query);
    }

    abstract public HashMap<Class<? extends DomainException>, HttpStatus> errorMapping();
}
