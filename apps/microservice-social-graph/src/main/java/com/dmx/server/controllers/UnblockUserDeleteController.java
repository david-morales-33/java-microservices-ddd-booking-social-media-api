package com.dmx.server.controllers;

import com.dmx.bus.command.CommandBus;
import com.dmx.bus.query.QueryBus;
import com.dmx.server.dto.UnblockUserRequest;
import com.dmx.shared.kernel.DomainException;
import com.dmx.social_graph.block.application.unblock_user.UnblockUserCommand;
import com.dmx.social_graph.block.domain.UserBlockNotAllowedException;
import com.dmx.social_graph.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/msvc-social-graph/")
public class UnblockUserDeleteController extends ApiController {
    public UnblockUserDeleteController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }
    @DeleteMapping(value = "/unblock-user")
    public ResponseEntity<String> index(@RequestBody UnblockUserRequest request) {

        UnblockUserCommand command = new UnblockUserCommand(request.userId(), request.blockedId());
        dispatch(command);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Override
    public HashMap<Class<? extends DomainException>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainException>, HttpStatus>(){{
            put(UserBlockNotAllowedException.class, HttpStatus.BAD_REQUEST);
        }};
    }
}
