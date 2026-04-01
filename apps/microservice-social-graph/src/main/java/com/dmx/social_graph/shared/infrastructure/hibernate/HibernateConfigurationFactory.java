package com.dmx.social_graph.shared.infrastructure.hibernate;

import com.dmx.shared.kernel.Service;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public final class HibernateConfigurationFactory {
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

        sessionFactory.setMappingLocations(mappingFiles.toArray(new Resource[mappingFiles.size()]));

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
        List<String> modules = subdirectoriesFor();
        List<String> goodPaths = new ArrayList<>();

        for (String module : modules) {
            String[] files = mappingFilesIn(module + "/infrastructure/persistence/hibernate/");

            for (String file : files) {
                goodPaths.add(module + "/infrastructure/persistence/hibernate/" + file);
            }
        }

        return goodPaths.stream().map(FileSystemResource::new).collect(Collectors.toList());
    }

    private List<String> subdirectoriesFor() {
        String path = "./microservice-social-graph/src/main/java/com/dmx/social_graph/";

        String[] files = new File(path).list((current, name) -> new File(current, name).isDirectory());
        if (null == files) {
            path = "./src/main/java/com/dmx/social_graph/";
            files = new File(path).list((current, name) -> new File(current, name).isDirectory());
        }

        if (null == files) {
            return Collections.emptyList();
        }

        String finalPath = path;

        return Arrays.stream(files).map(file -> finalPath + file).collect(Collectors.toList());
    }

    private String[] mappingFilesIn(String path) {
        List<String> fileList = new ArrayList<>();

        String[] hbmFiles = new File(path).list((current, name) -> new File(current, name).getName().contains(".hbm.xml"));
        String[] ormFiles = new File(path).list((current, name) -> new File(current, name).getName().contains(".orm.xml"));

        if (hbmFiles != null) {
            fileList.addAll(Arrays.asList(hbmFiles));
        }
        if (ormFiles != null) {
            fileList.addAll(Arrays.asList(ormFiles));
        }

        return fileList.toArray(new String[0]);
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put(AvailableSettings.HBM2DDL_AUTO, "update");
        hibernateProperties.put(AvailableSettings.SHOW_SQL, "true");
        hibernateProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        hibernateProperties.put(AvailableSettings.TRANSFORM_HBM_XML, true);

        return hibernateProperties;
    }
}
