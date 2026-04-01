package com.dmx.server.controllers;

import com.dmx.bus.command.CommandBus;
import com.dmx.bus.query.QueryBus;
import com.dmx.profile.shared.infrastructure.spring.ApiController;
import com.dmx.profile.user_profile.application.add_photo.AddPhotoCommand;
import com.dmx.profile.user_profile.domain.UserProfileNotFoundException;
import com.dmx.server.dto.AddPhotoRequest;
import com.dmx.shared.kernel.DomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/msvc-user-profile")
public class AddPhotoPostController extends ApiController {

    public AddPhotoPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PatchMapping(value = "/add-photo")
    public ResponseEntity<String> index(@RequestBody AddPhotoRequest request) {
        AddPhotoCommand command = new AddPhotoCommand(request.userId(), request.url(), request.type());

        dispatch(command);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainException>, HttpStatus> errorMapping() {
        return new HashMap<>() {{
            put(UserProfileNotFoundException.class, HttpStatus.NOT_FOUND);
        }};
    }
}
