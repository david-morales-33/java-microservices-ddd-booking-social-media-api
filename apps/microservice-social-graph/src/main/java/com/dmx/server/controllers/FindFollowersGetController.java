package com.dmx.server.controllers;

import com.dmx.bus.command.CommandBus;
import com.dmx.bus.query.QueryBus;
import com.dmx.shared.kernel.DomainException;
import com.dmx.social_graph.follow.application.find_followers_by_user.FindFollowerByUserQuery;
import com.dmx.social_graph.follow.application.find_followers_by_user.FollowerByUserResponse;
import com.dmx.social_graph.follow.domain.FollowDoesNotExistException;
import com.dmx.social_graph.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/msvc-social-graph")
public class FindFollowersGetController extends ApiController {

    public FindFollowersGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/followers/{userId}")
    public ResponseEntity<FollowerByUserResponse> index(@PathVariable("userId") String userId) {

        FindFollowerByUserQuery query = new FindFollowerByUserQuery(userId);
        FollowerByUserResponse followers = ask(query);
        return ResponseEntity.ok().body(followers);
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
