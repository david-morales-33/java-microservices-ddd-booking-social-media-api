package com.dmx.social_graph.shared.infrastructure.persistence.hibernate;

import com.dmx.infrastructure.persistence.hibernate.HibernateConfigurationFactory;
import com.dmx.shared.kernel.Service;
import org.springframework.core.io.support.ResourcePatternResolver;

@Service
public class SocialGraphHibernateConfigurationFactory extends HibernateConfigurationFactory {

    public SocialGraphHibernateConfigurationFactory(ResourcePatternResolver resourceResolver) {
        super(resourceResolver);
    }

    @Override
    protected String mappingFilesLocation() {
        return "classpath*:com/dmx/social_graph/**/infrastructure/persistence/hibernate/*.*.xml";
    }

    @Override
    protected String hbm2ddl() {
        return "update";
    }
}
