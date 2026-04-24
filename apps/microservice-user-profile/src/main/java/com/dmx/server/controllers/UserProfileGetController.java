package com.dmx.server.controllers;


import com.dmx.bus.command.CommandBus;
import com.dmx.bus.query.QueryBus;
import com.dmx.bus.query.QueryHandlerExecutionException;
import com.dmx.profile.shared.infrastructure.spring.ApiController;
import com.dmx.profile.user_profile.application.find.FindUserProfileQuery;
import com.dmx.profile.user_profile.application.find.UserProfileResponse;
import com.dmx.profile.user_profile.domain.UserProfileDTO;
import com.dmx.profile.user_profile.domain.UserProfileNotFoundException;
import com.dmx.shared.kernel.DomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/msvc-user-profile")
public class UserProfileGetController extends ApiController {

    public UserProfileGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDTO> index(@PathVariable("id") String id) throws QueryHandlerExecutionException {
        UserProfileResponse user = ask(new FindUserProfileQuery(id));
        return ResponseEntity.ok().body(user.response());
    }

    @Override
    public HashMap<Class<? extends DomainException>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainException>, HttpStatus>() {
            {
                put(UserProfileNotFoundException.class, HttpStatus.NOT_FOUND);
            }
        };
    }
}
