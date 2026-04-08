package com.dmx.app_notification.unread_notification_counter.application.increment;

import com.dmx.app_notification.notification.domain.UserId;
import com.dmx.app_notification.unread_notification_counter.domain.UnreadNotificationCounter;
import com.dmx.app_notification.unread_notification_counter.domain.UnreadNotificationCounterRepository;
import com.dmx.shared.kernel.Service;

@Service
public class UnreadNotificationCounterIncrementer {
    private final UnreadNotificationCounterRepository repository;

    public UnreadNotificationCounterIncrementer(UnreadNotificationCounterRepository repository) {
        this.repository = repository;
    }

    public void increment(UserId userId){
        UnreadNotificationCounter counter = repository.find(userId).orElseGet(() -> UnreadNotificationCounter.create(userId));
        counter.increment();
        repository.save(counter);
    }
}
