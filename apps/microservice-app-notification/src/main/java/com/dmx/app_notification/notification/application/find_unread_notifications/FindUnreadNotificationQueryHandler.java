package com.dmx.app_notification.notification.application.find_unread_notifications;

import com.dmx.app_notification.notification.domain.UserId;
import com.dmx.bus.query.QueryHandler;
import com.dmx.shared.kernel.Service;

@Service
public final class FindUnreadNotificationQueryHandler implements QueryHandler<FindUnreadNotificationQuery, UnreadNotificationResponse> {

    private final UnreadNotificationFinder finder;

    public FindUnreadNotificationQueryHandler(UnreadNotificationFinder finder) {
        this.finder = finder;
    }

    @Override
    public UnreadNotificationResponse handle(FindUnreadNotificationQuery query) {
        UserId recipientUserId = UserId.of(query.getRecipientUserId());
        return new UnreadNotificationResponse(finder.execute(recipientUserId));
    }
}
