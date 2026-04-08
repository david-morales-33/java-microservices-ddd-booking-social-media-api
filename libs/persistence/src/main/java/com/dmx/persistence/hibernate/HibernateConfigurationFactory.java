package com.dmx.persistence.hibernate;

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
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


public abstract class HibernateConfigurationFactory {
    private final ResourcePatternResolver resourceResolver;

    public HibernateConfigurationFactory(ResourcePatternResolver resourceResolver) {
        this.resourceResolver = resourceResolver;
    }

    public PlatformTransactionManager hibernateTransactionManager(LocalSessionFactoryBean sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory.getObject());

        return transactionManager;
    }

    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setHibernateProperties(hibernateProperties());

        List<Resource> mappingFiles = searchMappingFiles();

        sessionFactory.setMappingLocations(mappingFiles.toArray(new Resource[0]));

        return sessionFactory;
    }

    public DataSource dataSource(
            String host,
            Integer port,
            String databaseName,
            String username,
            String password
    ) throws IOException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(
                String.format(
                        "jdbc:postgresql://%s:%s/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                        host,
                        port,
                        databaseName
                )
        );
        System.out.println(dataSource.getUrl());
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    public List<Resource> searchMappingFiles() {
        try {
            Resource[] resources =
                    resourceResolver.getResources(mappingFilesLocation());

            return Arrays.asList(resources);
        } catch (IOException exception) {
            throw new IllegalStateException("Cannot load Hibernate mapping files from classpath", exception);
        }
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put(AvailableSettings.HBM2DDL_AUTO, hbm2ddl());
        hibernateProperties.put(AvailableSettings.SHOW_SQL, "true");
        hibernateProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        hibernateProperties.put(AvailableSettings.TRANSFORM_HBM_XML, true);

        return hibernateProperties;
    }
    abstract protected String mappingFilesLocation();
    abstract protected String hbm2ddl();
}
