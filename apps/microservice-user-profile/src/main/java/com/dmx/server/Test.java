package com.dmx.server;

import com.dmx.profile.shared.infrastructure.hibernate.HibernateConfigurationFactory;
import com.dmx.profile.user_profile.domain.UserProfile;
import com.dmx.profile.user_profile.domain.UserProfileId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {

        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        HibernateConfigurationFactory factory = new HibernateConfigurationFactory(resourceResolver);

        DataSource dataSource = factory.dataSource(
                "localhost",
                5432,
                "management_booking_social_media_user_profile",
                "admin",
                "Sistemas-2020"
        );


        LocalSessionFactoryBean sessionFactoryBean = factory.sessionFactory(dataSource);
        sessionFactoryBean.afterPropertiesSet();
        SessionFactory sessionFactory = sessionFactoryBean.getObject();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        UserProfile user = session.find(UserProfile.class, new UserProfileId("c1e662b7-564f-48d1-83d8-9e756659fbcb"));

        System.out.println(user.toPrimitives());
        transaction.commit();
    }
}
