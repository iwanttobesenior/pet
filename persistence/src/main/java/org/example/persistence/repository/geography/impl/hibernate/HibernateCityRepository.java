package org.example.persistence.repository.geography.impl.hibernate;

import org.example.application.domain.entity.geography.City;
import org.example.persistence.configuration.SessionFactoryBuilder;
import org.example.persistence.repository.geography.ICityRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

import static org.example.application.infrastructure.util.transformation.ReflectionUtil.getCurrentClassName;

/**
 * Implementation of {@link ICityRepository}
 *
 * @author Kul'baka Alex
 */
@Component
public class HibernateCityRepository implements ICityRepository {

    private static final Logger logger = LoggerFactory.getLogger(getCurrentClassName());

    private final SessionFactory sessionFactory;

    @Inject
    public HibernateCityRepository(SessionFactoryBuilder factoryBuilder) {
        this.sessionFactory = factoryBuilder.getSessionFactory();
    }

    @Override
    public void save(final City city) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try (session) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(city);
            transaction.commit();
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public City findById(final long cityId) {
        Session session = sessionFactory.openSession();
        try (session) {
            return session.get(City.class, cityId);
        }
    }

    @Override
    public void delete(final int cityId) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try (session) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete from City where City.id = :cityId");
            query.setParameter("cityId", cityId);
            query.executeUpdate();
            transaction.commit();
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
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
