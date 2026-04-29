package com.dmx.social_graph.user.application.subcribers;

import com.dmx.bus.event.DomainEventSubscriber;
import com.dmx.shared.kernel.Service;
import com.dmx.social_graph.shared.domain.events.UserProfileCreatedDomainEvent;
import com.dmx.social_graph.user.domain.UserDTO;
import com.dmx.social_graph.user.domain.UserRepository;

@Service
public class NewUserOnProfileCreated implements DomainEventSubscriber<UserProfileCreatedDomainEvent> {

    private final UserRepository repository;

    public NewUserOnProfileCreated(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void on(UserProfileCreatedDomainEvent event) {
        String userId = event.aggregateId();
        UserDTO user = new UserDTO(userId, event.getName(), event.getNickname(), event.getPhoto());
        if (!repository.existsUser(userId))
            repository.save(user);
    }

    @Override
    public Class<UserProfileCreatedDomainEvent> subscribedTo() {
        return UserProfileCreatedDomainEvent.class;
    }
}
