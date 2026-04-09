package com.dmx.social_graph.shared.infrastructure.hibernate;

import com.dmx.social_graph.shared.infrastructure.config.Parameter;
import com.dmx.social_graph.shared.infrastructure.config.ParameterNotExist;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableTransactionManagement
public class SocialGraphHibernateConfiguration {
    private final SocialGraphHibernateConfigurationFactory factory;
    private final Parameter                     config;

    public SocialGraphHibernateConfiguration(SocialGraphHibernateConfigurationFactory factory, Parameter config) {
        this.factory = factory;
        this.config  = config;
    }

    @Bean("social_graph-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }

    @Bean("social_graph-session_factory")
    public LocalSessionFactoryBean sessionFactory() throws IOException, ParameterNotExist {
        return factory.sessionFactory(dataSource());
    }

    @Bean("social_graph-data_source")
    public DataSource dataSource() throws IOException, ParameterNotExist {
        return factory.dataSource(
            config.get("SOCIAL_GRAPH_DATABASE_HOST"),
            config.getInt("SOCIAL_GRAPH_DATABASE_PORT"),
            config.get("SOCIAL_GRAPH_DATABASE_NAME"),
            config.get("SOCIAL_GRAPH_DATABASE_USER"),
            config.get("SOCIAL_GRAPH_DATABASE_PASSWORD")
        );
    }
}
