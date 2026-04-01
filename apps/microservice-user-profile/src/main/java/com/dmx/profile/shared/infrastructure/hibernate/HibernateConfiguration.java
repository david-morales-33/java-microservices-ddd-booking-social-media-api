package com.dmx.profile.shared.infrastructure.hibernate;

import com.dmx.profile.shared.infrastructure.config.Parameter;
import com.dmx.profile.shared.infrastructure.config.ParameterNotExist;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

//@Configuration
//@EnableTransactionManagement
public class HibernateConfiguration {
    private final HibernateConfigurationFactory factory;
    private final Parameter config;
    private final String CONTEXT_NAME;

    public HibernateConfiguration(HibernateConfigurationFactory var1, Parameter var2) {
        throw new Error("Unresolved compilation problems: \n\tThe type java.lang.Object cannot be resolved. It is indirectly referenced from required .class files\n\tThe type java.lang.Object cannot be resolved. It is indirectly referenced from required .class files\n\tThe declared package \"com.dmx.profile.shared.infrastructure.persistence\" does not match the expected package \"main.com.dmx.profile.shared.infrastructure.persistence\"\n\tThe import org cannot be resolved\n\tThe import org cannot be resolved\n\tThe import org cannot be resolved\n\tThe import org cannot be resolved\n\tThe import org cannot be resolved\n\tThe import tv cannot be resolved\n\tThe import tv cannot be resolved\n\tThe import tv cannot be resolved\n\tThe import javax cannot be resolved\n\tThe import java.io cannot be resolved\n\tConfiguration cannot be resolved to a type\n\tEnableTransactionManagement cannot be resolved to a type\n\tHibernateConfigurationFactory cannot be resolved to a type\n\tParameter cannot be resolved to a type\n\tString cannot be resolved to a type\n\tImplicit super constructor Object() is undefined. Must explicitly invoke another constructor\n\tHibernateConfigurationFactory cannot be resolved to a type\n\tParameter cannot be resolved to a type\n\tHibernateConfigurationFactory cannot be resolved to a type\n\tParameter cannot be resolved to a type\n\tBean cannot be resolved to a type\n\tPlatformTransactionManager cannot be resolved to a type\n\tIOException cannot be resolved to a type\n\tParameterNotExist cannot be resolved to a type\n\tHibernateConfigurationFactory cannot be resolved to a type\n\tThe method sessionFactory() from the type MoocHibernateConfiguration refers to the missing type LocalSessionFactoryBean\n\tBean cannot be resolved to a type\n\tLocalSessionFactoryBean cannot be resolved to a type\n\tIOException cannot be resolved to a type\n\tParameterNotExist cannot be resolved to a type\n\tHibernateConfigurationFactory cannot be resolved to a type\n\tString cannot be resolved to a type\n\tThe method dataSource() from the type MoocHibernateConfiguration refers to the missing type DataSource\n\tBean cannot be resolved to a type\n\tDataSource cannot be resolved to a type\n\tIOException cannot be resolved to a type\n\tParameterNotExist cannot be resolved to a type\n\tHibernateConfigurationFactory cannot be resolved to a type\n\tParameter cannot be resolved to a type\n\tParameter cannot be resolved to a type\n\tParameter cannot be resolved to a type\n\tParameter cannot be resolved to a type\n\tParameter cannot be resolved to a type\n");
    }

    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
        throw new Error("Unresolved compilation problems: \n\tBean cannot be resolved to a type\n\tPlatformTransactionManager cannot be resolved to a type\n\tIOException cannot be resolved to a type\n\tParameterNotExist cannot be resolved to a type\n\tHibernateConfigurationFactory cannot be resolved to a type\n\tThe method sessionFactory() from the type MoocHibernateConfiguration refers to the missing type LocalSessionFactoryBean\n");
    }

    public LocalSessionFactoryBean sessionFactory() throws IOException, ParameterNotExist {
        throw new Error("Unresolved compilation problems: \n\tBean cannot be resolved to a type\n\tLocalSessionFactoryBean cannot be resolved to a type\n\tIOException cannot be resolved to a type\n\tParameterNotExist cannot be resolved to a type\n\tHibernateConfigurationFactory cannot be resolved to a type\n\tString cannot be resolved to a type\n\tThe method dataSource() from the type MoocHibernateConfiguration refers to the missing type DataSource\n");
    }

    public DataSource dataSource() throws IOException, ParameterNotExist {
        throw new Error("Unresolved compilation problems: \n\tBean cannot be resolved to a type\n\tDataSource cannot be resolved to a type\n\tIOException cannot be resolved to a type\n\tParameterNotExist cannot be resolved to a type\n\tHibernateConfigurationFactory cannot be resolved to a type\n\tParameter cannot be resolved to a type\n\tParameter cannot be resolved to a type\n\tParameter cannot be resolved to a type\n\tParameter cannot be resolved to a type\n\tParameter cannot be resolved to a type\n");
    }
}
