package org.example.persistence.configuration;

import org.example.application.infrastructure.exception.uncheked.persistence.PersistenceException;
import org.example.application.infrastructure.util.transformation.ReflectionUtil;
import org.example.persistence.interceptor.TimestampHibernateInterceptor;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.annotation.PreDestroy;
import javax.inject.Named;
import javax.persistence.Entity;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * Hibernate configuration bean
 *
 * @author Kul'baka Alex
 */
@Named
public class SessionFactoryBuilder {

    private final SessionFactory sessionFactory;

    public SessionFactoryBuilder() {
        var builder = new StandardServiceRegistryBuilder()
                .applySettings(loadProperties())
                .build();
        MetadataSources metadataSources = new MetadataSources(builder);

        ReflectionUtil
                .getClassesByAnnotation(Entity.class)
                .forEach(metadataSources::addAnnotatedClass);
        /*
          Add interceptor to hibernate configuration
         */
        org.hibernate.boot.SessionFactoryBuilder sessionFactoryBuilder =
                metadataSources.getMetadataBuilder()
                        .build()
                        .getSessionFactoryBuilder()
                        .applyInterceptor(new TimestampHibernateInterceptor());

        this.sessionFactory = sessionFactoryBuilder.build();
    }

    /**
     * Load {@code application.properties} fro hibernate additional configuration
     *
     * @throws NullPointerException if suck properties don't exist
     * @throws PersistenceException if existing properties loading failed
     */
    private Properties loadProperties() {
        final var stream = SessionFactoryBuilder
                .class
                .getClassLoader()
                .getResourceAsStream("application.properties");

        final var properties = new Properties();
        try {
            properties
                    .load(Objects
                            .requireNonNull(stream, "such properties not exist: " + stream));
            return properties;
        } catch (IOException e) {
            throw new PersistenceException("load properties was failed", e);
        }
    }

    /**
     * Close {@code sessionFactory} and rid resources when application stopped
     */
    @PreDestroy
    public void destroy() {
        if (sessionFactory != null) {
            sessionFactory.close();
            System.out.println("!!!!!!!");
            // TODO: 04.03.2019
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
