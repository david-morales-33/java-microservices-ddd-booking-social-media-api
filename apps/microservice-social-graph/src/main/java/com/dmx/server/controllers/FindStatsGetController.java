package com.dmx.server.controllers;

import com.dmx.bus.command.CommandBus;
import com.dmx.bus.query.QueryBus;
import com.dmx.infrastructure.spring.ApiController;
import com.dmx.shared.kernel.DomainException;
import com.dmx.shared.kernel.ValueObjectException;
import com.dmx.social_graph.stats.application.find.FindStatsQuery;
import com.dmx.social_graph.stats.application.find.StatsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/msvc-social-graph")
public class FindStatsGetController extends ApiController {
    public FindStatsGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/stats/{userId}")
    public ResponseEntity<StatsResponse> index(@PathVariable("userId") String userId) {
        FindStatsQuery query = new FindStatsQuery(userId);
        StatsResponse response = ask(query);
        return ResponseEntity.ok().body(response);
    }

    @Override
    public HashMap<Class<? extends DomainException>, HttpStatus> errorMapping() {
        return new HashMap<>() {{
            put(ValueObjectException.class, HttpStatus.BAD_REQUEST);
        }};
    }
}
