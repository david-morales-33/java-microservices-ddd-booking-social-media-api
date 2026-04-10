package com.dmx.app_notification.shared.infrastructure.persistence.hibernate;

import com.dmx.infrastructure.persistence.hibernate.HibernateConfigurationFactory;
import com.dmx.shared.kernel.Service;
import org.springframework.core.io.support.ResourcePatternResolver;

@Service
public class NotificationHibernateConfigurationFactory extends HibernateConfigurationFactory {
    public NotificationHibernateConfigurationFactory(ResourcePatternResolver resourceResolver) {
        super(resourceResolver);
    }

    @Override
    protected String mappingFilesLocation() {
        return "classpath*:com/dmx/app_notification/**/infrastructure/persistence/hibernate/*.*.xml";
    }

    @Override
    protected String hbm2ddl() {
        return "update";
    }
}
