package com.dmx.social_graph.shared.infrastructure.hibernate;

import com.dmx.persistence.hibernate.HibernateConfigurationFactory;
import com.dmx.shared.kernel.Service;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.*;

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
