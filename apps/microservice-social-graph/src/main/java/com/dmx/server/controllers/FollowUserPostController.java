package com.dmx.server.controllers;

import com.dmx.bus.command.CommandBus;
import com.dmx.bus.query.QueryBus;
import com.dmx.server.dto.FollowUserRequest;
import com.dmx.shared.kernel.DomainException;
import com.dmx.social_graph.follow.application.follow_user.FollowUserCommand;
import com.dmx.social_graph.follow.domain.FollowAlreadyExists;
import com.dmx.social_graph.follow.domain.UserFollowThemselvesExecption;
import com.dmx.social_graph.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/msvc-social-graph")
public class FollowUserPostController extends ApiController {

    public FollowUserPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/follow-user")
    public ResponseEntity<String> index(@RequestBody FollowUserRequest request) {

        FollowUserCommand command = new FollowUserCommand(request.followedId(), request.followerId());
        dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public HashMap<Class<? extends DomainException>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainException>, HttpStatus>() {
            {
                put(FollowAlreadyExists.class, HttpStatus.BAD_REQUEST);
                put(UserFollowThemselvesExecption.class, HttpStatus.FORBIDDEN);
            }
        };
    }
}
