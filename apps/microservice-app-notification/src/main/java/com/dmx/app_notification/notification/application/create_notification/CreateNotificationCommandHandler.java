package com.dmx.app_notification.notification.application.create_notification;

import com.dmx.app_notification.notification.domain.NotificationType;
import com.dmx.app_notification.notification.domain.ReferenceId;
import com.dmx.app_notification.notification.domain.UserId;
import com.dmx.bus.command.CommandHandler;
import com.dmx.shared.kernel.Service;

@Service
public final class CreateNotificationCommandHandler implements CommandHandler<CreateNotificationCommand> {
    private final NotificationCreator creator;

    public CreateNotificationCommandHandler(NotificationCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateNotificationCommand command) {
        UserId recipientUserId = UserId.of(command.getRecipientUserId());
        UserId sourceUserId = UserId.of(command.getSourceUserId());
        NotificationType type = NotificationType.valueOf(command.getType());
        ReferenceId referenceId = ReferenceId.of(command.getReferenceId());
        
        creator.create(recipientUserId, sourceUserId, type, referenceId);
    }
}
