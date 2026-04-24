package com.dmx.profile.shared.infrastructure.persistence.hibernate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.dmx.profile.shared.infrastructure.config.Parameter;
import com.dmx.profile.shared.infrastructure.config.ParameterNotExist;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableTransactionManagement
public class ProfileHibernateConfiguration {
    private final ProfileHibernateConfigurationFactory factory;
    private final Parameter                     config;

    public ProfileHibernateConfiguration(ProfileHibernateConfigurationFactory factory, Parameter config) {
        this.factory = factory;
        this.config  = config;
    }

    @Bean("profile-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }

    @Bean("profile-session_factory")
    public LocalSessionFactoryBean sessionFactory() throws IOException, ParameterNotExist {
        return factory.sessionFactory(dataSource());
    }

    @Bean("profile-data_source")
    public DataSource dataSource() throws IOException, ParameterNotExist {
        return factory.dataSource(
            config.get("USER_PROFILE_DATABASE_HOST"),
            config.getInt("USER_PROFILE_DATABASE_PORT"),
            config.get("USER_PROFILE_DATABASE_NAME"),
            config.get("USER_PROFILE_DATABASE_USER"),
            config.get("USER_PROFILE_DATABASE_PASSWORD")
        );
    }
}
