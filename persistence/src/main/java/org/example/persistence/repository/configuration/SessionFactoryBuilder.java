package org.example.persistence.repository.configuration;

import org.example.application.domain.entity.geography.City;
import org.example.application.domain.entity.geography.Country;
import org.example.application.domain.entity.geography.Station;
import org.example.application.domain.entity.person.Account;
import org.example.application.domain.entity.valueobject.Address;
import org.example.application.domain.entity.valueobject.Coordinates;
import org.example.application.domain.entity.valueobject.Phone;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * Hibernate configuration bean
 *
 * @author Kul'baka Alex
 */
@Component
public class SessionFactoryBuilder {

    private final SessionFactory sessionFactory;

    public SessionFactoryBuilder() {
        ServiceRegistry builder = new StandardServiceRegistryBuilder().build();
        MetadataSources metadataSources = new MetadataSources(builder);

        metadataSources.addAnnotatedClass(City.class);
        metadataSources.addAnnotatedClass(Country.class);
        metadataSources.addAnnotatedClass(Phone.class);
        metadataSources.addAnnotatedClass(Station.class);
        metadataSources.addAnnotatedClass(Account.class);
        metadataSources.addAnnotatedClass(Address.class);
        metadataSources.addAnnotatedClass(Coordinates.class);

        this.sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
    }

    @PreDestroy
    public void destroy() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
