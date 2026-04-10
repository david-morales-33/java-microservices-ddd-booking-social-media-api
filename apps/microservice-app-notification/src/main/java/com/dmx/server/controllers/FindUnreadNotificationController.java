package com.dmx.server.controllers;

import com.dmx.app_notification.notification.application.find_unread_notifications.FindUnreadNotificationQuery;
import com.dmx.app_notification.notification.application.find_unread_notifications.UnreadNotificationResponse;
import com.dmx.app_notification.shared.domain.events.UserFollowedDomainEvent;
import com.dmx.app_notification.shared.infrastructure.bus.event.AppNotificationDomainEventSubscribersInformation;
import com.dmx.app_notification.shared.infrastructure.bus.event.AppNotificationSubscribersHandler;
import com.dmx.bus.command.CommandBus;
import com.dmx.bus.query.QueryBus;
import com.dmx.infrastructure.spring.ApiController;
import com.dmx.shared.kernel.DomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/msvc-app-notification")
public class FindUnreadNotificationController extends ApiController {

    AppNotificationSubscribersHandler handler;

    public FindUnreadNotificationController(QueryBus queryBus, CommandBus commandBus, AppNotificationSubscribersHandler handler) {
        super(queryBus, commandBus);
        this.handler= handler;
    }

    @GetMapping(value = "/unread-notification/{recipientUserId}")
    public ResponseEntity<UnreadNotificationResponse> index(@PathVariable("recipientUserId") String recipientUserId) {
        FindUnreadNotificationQuery query= new FindUnreadNotificationQuery(recipientUserId);
        UnreadNotificationResponse response =ask(query);

        UserFollowedDomainEvent event = new UserFollowedDomainEvent(
                "0c41f247-8da0-47a9-aaf6-68e03a9c0006",
                "0c41f247-8da0-47a9-aaf6-68e03a9c0001",
                "0c41f247-8da0-47a9-aaf6-68e03a9c0000");
        handler.handle(event);

        return ResponseEntity.ok().body(response);
    }

    @Override
    public HashMap<Class<? extends DomainException>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainException>, HttpStatus>() {};
    }
}
