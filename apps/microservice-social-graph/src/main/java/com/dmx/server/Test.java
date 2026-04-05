package com.dmx.server;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.dmx.social_graph.shared.infrastructure.hibernate.HibernateConfigurationFactory;

import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;

public class Test {
    public static void main(String[] args)  throws IOException {

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
