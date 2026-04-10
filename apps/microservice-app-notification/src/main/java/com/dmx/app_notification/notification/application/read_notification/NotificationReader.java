package com.dmx.app_notification.notification.application.read_notification;

import com.dmx.app_notification.notification.domain.Notification;
import com.dmx.app_notification.notification.domain.NotificationId;
import com.dmx.app_notification.notification.domain.NotificationNotFoundException;
import com.dmx.app_notification.notification.domain.NotificationRepository;
import com.dmx.bus.event.EventBus;
import com.dmx.shared.kernel.Service;

import java.util.Optional;

@Service
public class NotificationReader {
    private final NotificationRepository repository;
    private final EventBus bus;

    public NotificationReader(NotificationRepository repository, EventBus bus) {
        this.repository = repository;
        this.bus = bus;
    }

    void execute(NotificationId id) {
        Optional<Notification> response = repository.find(id);
        if (response.isEmpty()) {
            throw new NotificationNotFoundException(id);
        }
        Notification notification = response.get();

        notification.read();
        repository.save(notification);
        bus.publish(notification.pullDomainEvents());
    }
}
