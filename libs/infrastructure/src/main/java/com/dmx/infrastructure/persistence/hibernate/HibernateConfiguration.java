package com.dmx.infrastructure.persistence.hibernate;

import com.dmx.infrastructure.config.Parameter;
import com.dmx.infrastructure.config.ParameterNotExist;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

public abstract class HibernateConfiguration {
    private final HibernateConfigurationFactory factory;
    private final Parameter config;

    abstract public String host();

    abstract public String port();

    abstract public String name();

    abstract public String user();

    abstract public String password();

    public HibernateConfiguration(HibernateConfigurationFactory factory, Parameter config) {
        this.factory = factory;
        this.config = config;
    }

    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }

    public LocalSessionFactoryBean sessionFactory() throws IOException, ParameterNotExist {
        return factory.sessionFactory(dataSource());
    }

    public DataSource dataSource() throws IOException, ParameterNotExist {
        return factory.dataSource(
                config.get(host()),
                config.getInt(port()),
                config.get(name()),
                config.get(user()),
                config.get(password())
        );
    }
}
