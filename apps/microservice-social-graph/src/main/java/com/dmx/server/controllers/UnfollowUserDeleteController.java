package com.dmx.server.controllers;

import com.dmx.bus.command.CommandBus;
import com.dmx.bus.query.QueryBus;
import com.dmx.infrastructure.spring.ApiController;
import com.dmx.server.dto.UnblockUserRequest;
import com.dmx.shared.kernel.DomainException;
import com.dmx.social_graph.follow.application.unfollow_user.UnfollowUserCommand;
import com.dmx.social_graph.follow.domain.FollowDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/msvc-social-graph/")
public class UnfollowUserDeleteController extends ApiController {
    public UnfollowUserDeleteController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @DeleteMapping(value = "/unfollow-user")
    public ResponseEntity<String> index(@RequestBody UnblockUserRequest request) {

        UnfollowUserCommand command = new UnfollowUserCommand(request.userId(), request.blockedId());
        dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public HashMap<Class<? extends DomainException>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainException>, HttpStatus>() {{
            put(FollowDoesNotExistException.class, HttpStatus.BAD_REQUEST);
        }};
    }
}
