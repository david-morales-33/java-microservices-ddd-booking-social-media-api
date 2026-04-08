package com.dmx.app_notification.shared.infrastructure.persistence.hibernate;

import com.dmx.app_notification.shared.infrastructure.config.Parameter;
import com.dmx.app_notification.shared.infrastructure.config.ParameterNotExist;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class NotificationHibernateConfiguration {
    private final NotificationHibernateConfigurationFactory factory;
    private final Parameter config;

    public NotificationHibernateConfiguration(NotificationHibernateConfigurationFactory factory, Parameter config) {
        this.factory = factory;
        this.config  = config;
    }

    @Bean("app_notification-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }

    @Bean("app_notification-session_factory")
    public LocalSessionFactoryBean sessionFactory() throws IOException, ParameterNotExist {
        return factory.sessionFactory(dataSource());
    }

    @Bean("app_notification-data_source")
    public DataSource dataSource() throws IOException, ParameterNotExist {
        return factory.dataSource(
                config.get("APP_NOTIFICATION_DATABASE_HOST"),
                config.getInt("APP_NOTIFICATION_DATABASE_PORT"),
                config.get("APP_NOTIFICATION_DATABASE_NAME"),
                config.get("APP_NOTIFICATION_DATABASE_USER"),
                config.get("APP_NOTIFICATION_DATABASE_PASSWORD")
        );
    }
}
