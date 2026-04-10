package com.dmx.social_graph.shared.infrastructure.bus.command;

import com.dmx.infrastructure.bus.command.CommandHandlersInformation;
import com.dmx.shared.kernel.Service;

@Service
public final class SocialGraphCommandHandlersInformation extends CommandHandlersInformation {
    @Override
    protected String getPackageToScan() {
        return "com.dmx.social_graph";
    }
}
