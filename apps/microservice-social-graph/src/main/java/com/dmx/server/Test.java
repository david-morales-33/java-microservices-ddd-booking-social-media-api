package com.dmx.server;


import com.dmx.shared.kernel.events.OutboxEvent;
import com.dmx.social_graph.shared.infrastructure.config.ParameterNotExist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.dmx.social_graph.shared.infrastructure.hibernate.HibernateConfigurationFactory;

import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException, ParameterNotExist {

        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        HibernateConfigurationFactory factory = new HibernateConfigurationFactory(resourceResolver);

        DataSource dataSource = factory.dataSource(
                "localhost",
                5432,
                "management_booking_social_media_social_graph",
                "admin",
                "Sistemas-2020"
        );


        LocalSessionFactoryBean sessionFactoryBean = factory.sessionFactory(dataSource);
        sessionFactoryBean.afterPropertiesSet();
        SessionFactory sessionFactory = sessionFactoryBean.getObject();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();


        transaction.commit();
    }
}
