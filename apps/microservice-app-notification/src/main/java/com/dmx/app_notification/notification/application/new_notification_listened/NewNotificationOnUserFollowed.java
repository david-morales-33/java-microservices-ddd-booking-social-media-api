package com.dmx.app_notification.notification.application.new_notification_listened;

import com.dmx.app_notification.notification.domain.NotificationType;
import com.dmx.app_notification.notification.domain.ReferenceId;
import com.dmx.app_notification.notification.domain.UserId;
import com.dmx.app_notification.shared.domain.events.UserFollowedDomainEvent;
import com.dmx.bus.event.DomainEventSubscriber;
import com.dmx.shared.kernel.Service;

@Service
public class NewNotificationOnUserFollowed implements DomainEventSubscriber<UserFollowedDomainEvent> {
    private final NotificationCreator creator;

    public NewNotificationOnUserFollowed(NotificationCreator creator) {
        this.creator = creator;
    }

    @Override
    public Class<UserFollowedDomainEvent> subscribedTo() {
        return UserFollowedDomainEvent.class;
    }

    @Override
    public void on(UserFollowedDomainEvent event) {
        UserId recipientUserId = new UserId(event.getFollowedId());
        UserId sourceUserId = new UserId(event.getFollowerId());
        NotificationType type = NotificationType.follow();
        ReferenceId referenceId = new ReferenceId("social-graph-follow");
        creator.create(recipientUserId, sourceUserId, type, referenceId);
    }
}
