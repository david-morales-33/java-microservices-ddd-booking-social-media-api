package com.dmx.server.controllers;

import com.dmx.bus.command.CommandBus;
import com.dmx.bus.query.QueryBus;
import com.dmx.infrastructure.spring.ApiController;
import com.dmx.server.dto.BlockUserRequest;
import com.dmx.shared.kernel.DomainException;
import com.dmx.social_graph.block.application.block_user.BlockUserCommand;
import com.dmx.social_graph.block.domain.UserBlockNotAllowedException;
import com.dmx.social_graph.block.domain.UserBlockThemselvesExcecption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/msvc-social-graph/")
public class BlockUserPostController extends ApiController {
    public BlockUserPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/block-user")
    public ResponseEntity<String> index(@RequestBody BlockUserRequest request) {

        BlockUserCommand command = new BlockUserCommand(request.userId(), request.blockedId());
        dispatch(command);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public HashMap<Class<? extends DomainException>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainException>, HttpStatus>(){{
            put(UserBlockNotAllowedException.class, HttpStatus.BAD_REQUEST);
            put(UserBlockThemselvesExcecption.class, HttpStatus.FORBIDDEN);
        }};
    }

}
