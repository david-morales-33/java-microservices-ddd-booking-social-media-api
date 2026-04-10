package com.dmx.server.controllers;

import com.dmx.bus.command.CommandBus;
import com.dmx.bus.query.QueryBus;
import com.dmx.infrastructure.spring.ApiController;
import com.dmx.shared.kernel.DomainException;
import com.dmx.social_graph.follow.application.find_following_by_user.FindFollowingByUserQuery;
import com.dmx.social_graph.follow.application.find_following_by_user.FollowingByUserResponse;
import com.dmx.social_graph.follow.domain.FollowDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/msvc-social-graph")
public class FindFollowingGetController extends ApiController {
    public FindFollowingGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/following/{userId}")
    public ResponseEntity<FollowingByUserResponse> index(@PathVariable("userId") String userId) {
        FindFollowingByUserQuery query = new FindFollowingByUserQuery(userId);
        FollowingByUserResponse response = ask(query);
        return ResponseEntity.ok().body(response);
    }

    @Override
    public HashMap<Class<? extends DomainException>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainException>, HttpStatus>() {
            {
                put(FollowDoesNotExistException.class, HttpStatus.NOT_FOUND);
            }
        };
    }
}
