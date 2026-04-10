package com.dmx.app_notification.shared.infrastructure.bus.query;

import com.dmx.infrastructure.bus.query.QueryHandlersInformation;
import com.dmx.shared.kernel.Service;

@Service
public final class AppNotificationQueryHandlersInformation extends QueryHandlersInformation {
    @Override
    protected String getPackageToScan() {
        return "com.dmx.app_notification";
    }
}
