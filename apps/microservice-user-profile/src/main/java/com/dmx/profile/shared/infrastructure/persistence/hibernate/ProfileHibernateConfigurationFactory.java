package com.dmx.profile.shared.infrastructure.persistence.hibernate;

import com.dmx.infrastructure.persistence.hibernate.HibernateConfigurationFactory;
import com.dmx.shared.kernel.Service;
import org.springframework.core.io.support.ResourcePatternResolver;

@Service
public final class ProfileHibernateConfigurationFactory extends HibernateConfigurationFactory {
    public ProfileHibernateConfigurationFactory(ResourcePatternResolver resourceResolver) {
        super(resourceResolver);
    }

    @Override
    protected String mappingFilesLocation() {
        return "classpath*:com/dmx/profile/**/infrastructure/persistence/hibernate/*.*.xml";
    }

    @Override
    protected String hbm2ddl() {
        return "update";
    }
}
