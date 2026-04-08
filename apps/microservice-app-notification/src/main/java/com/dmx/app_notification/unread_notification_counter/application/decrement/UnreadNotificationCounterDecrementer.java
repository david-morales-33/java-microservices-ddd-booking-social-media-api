package com.dmx.app_notification.unread_notification_counter.application.decrement;

import com.dmx.app_notification.notification.domain.UserId;
import com.dmx.app_notification.unread_notification_counter.domain.UnreadNotificationCounter;
import com.dmx.app_notification.unread_notification_counter.domain.UnreadNotificationCounterRepository;
import com.dmx.shared.kernel.Service;

@Service
public class UnreadNotificationCounterDecrementer {
    private final UnreadNotificationCounterRepository repository;

    public UnreadNotificationCounterDecrementer(UnreadNotificationCounterRepository repository) {
        this.repository = repository;
    }

    public void decrement(UserId userId){
        UnreadNotificationCounter counter = repository.find(userId).orElseGet(() -> UnreadNotificationCounter.create(userId));
        counter.decrement();
        repository.save(counter);
    }
}
