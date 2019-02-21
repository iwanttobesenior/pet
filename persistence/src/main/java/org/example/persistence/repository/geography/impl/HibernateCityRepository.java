package org.example.persistence.repository.geography.impl;

import org.example.application.domain.entity.geography.City;
import org.example.persistence.repository.configuration.SessionFactoryBuilder;
import org.example.persistence.repository.geography.ICityRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * @author Kul'baka Alex
 */
public class HibernateCityRepository implements ICityRepository {

    private final SessionFactory sessionFactory;

    @Inject
    public HibernateCityRepository(SessionFactoryBuilder factoryBuilder) {
        this.sessionFactory = factoryBuilder.getSessionFactory();
    }

    @Override
    public void save(final City city) {
        Session session = sessionFactory.openSession();
        try (session) {
            session.saveOrUpdate(city);
        }
    }

    @Override
    public City findById(final long cityId) {
        Session session = sessionFactory.openSession();
        try (session) {
            session.get(City.class, cityId);
        }
    }

    @Override
    public void delete(final int cityId) {
        Session session = sessionFactory.openSession();
        try (session) {
            Query query = session.createQuery("delete from City where City.id = :cityId");
            query.setParameter("cityId", cityId);
            query.executeUpdate();
        }
    }

    @Override
    public List<City> findAll() {
        Session session = sessionFactory.openSession();
        try (session) {
            CriteriaQuery<City> query = session.getCriteriaBuilder().createQuery(City.class);
            query.from(City.class);
            return session.createQuery(query).getResultList();
        }
    }
}
