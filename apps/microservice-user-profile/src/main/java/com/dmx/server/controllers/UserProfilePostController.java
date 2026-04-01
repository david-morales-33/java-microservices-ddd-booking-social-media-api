package com.dmx.server.controllers;

import com.dmx.bus.command.Command;
import com.dmx.bus.command.CommandBus;
import com.dmx.bus.query.QueryBus;
import com.dmx.profile.shared.infrastructure.spring.ApiController;
import com.dmx.profile.user_profile.application.create_user_profile.CreateUserProfileCommand;
import com.dmx.profile.user_profile.domain.UserProfileAlreadyExistsException;
import com.dmx.server.dto.CreateUserProfileRequest;
import com.dmx.shared.kernel.DomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/msvc-user-profile")
public class UserProfilePostController extends ApiController {
    public UserProfilePostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/create-user-profile")
    public ResponseEntity<String> index(@RequestBody CreateUserProfileRequest request) {

        Command newUser = new CreateUserProfileCommand(
                request.id(),
                request.name(),
                request.nickname(),
                request.email(),
                request.age(),
                request.gender(),
                request.description()
        );
        dispatch(newUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainException>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainException>, HttpStatus>() {{
            put(UserProfileAlreadyExistsException.class, HttpStatus.BAD_REQUEST);
        }};
    }
}
