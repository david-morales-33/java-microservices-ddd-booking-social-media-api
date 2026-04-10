package com.dmx.social_graph.shared.infrastructure.bus.query;

import com.dmx.infrastructure.bus.query.QueryHandlersInformation;
import com.dmx.shared.kernel.Service;

@Service
public final class SocialGraphQueryHandlersInformation extends QueryHandlersInformation {
    @Override
    protected String getPackageToScan() {
        return "com.dmx.social_graph";
    }
}
