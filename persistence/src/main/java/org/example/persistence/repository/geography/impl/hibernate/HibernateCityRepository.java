package org.example.persistence.repository.geography.impl.hibernate;

import org.example.application.domain.entity.geography.City;
import org.example.persistence.configuration.SessionFactoryBuilder;
import org.example.persistence.infrastructure.cdi.DatabaseSourceHibernateImpl;
import org.example.persistence.repository.geography.ICityRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import static org.example.application.infrastructure.util.transformation.ReflectionUtil.getCurrentClassName;

/**
 * Implementation of {@link ICityRepository} by hibernate provider
 *
 * @author Kul'baka Alex
 * @see SessionFactoryBuilder
 */
@Named
@DatabaseSourceHibernateImpl
public final class HibernateCityRepository implements ICityRepository {

    private static final Logger logger = LoggerFactory.getLogger(getCurrentClassName());
    private final SessionFactory sessionFactory;

    @Inject
    public HibernateCityRepository(final SessionFactoryBuilder factoryBuilder) {
        this.sessionFactory = factoryBuilder.getSessionFactory();
    }

    @Override
    public void save(final City city) {
        Transaction transaction = null;
        final Session session = sessionFactory.openSession();
        try (session) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(city);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public City findById(final long cityId) {
        final Session session = sessionFactory.openSession();
        try (session) {
            return session.get(City.class, cityId);
        }
    }

    @Override
    public void deleteById(final long cityId) {
        Transaction transaction = null;
        final Session session = sessionFactory.openSession();
        try (session) {
            transaction = session.beginTransaction();
            final var city = session.get(City.class, cityId);
            if (city != null) {
                session.delete(city);
            }
            transaction.commit();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<City> findAll() {
        final Session session = sessionFactory.openSession();
        try (session) {
            final var query = session.getCriteriaBuilder().createQuery(City.class);
            query.from(City.class);
            return session.createQuery(query).getResultList();
        }
    }

    @Override
    public void deleteAll() {
        Transaction transaction = null;
        final Session session = sessionFactory.openSession();
        try (session) {
            transaction = session.beginTransaction();
            final Query query = session.createQuery(City.DELETE_ALL_QUERY);
            final int countOfDeleted = query.executeUpdate();
            logger.debug("Deleted {} cities ", countOfDeleted);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void saveAll(final List<City> cities) {
        Transaction transaction = null;
        final Session session = sessionFactory.openSession();
        final int batchSize = session.getJdbcBatchSize();
        try (session) {
            transaction = session.beginTransaction();
            for (int i = 0; i < cities.size(); i++) {
                session.persist(cities.get(i));
                // TODO: 26.02.2019 resolve
                if (i % batchSize == 0 || i == cities.size() - 1) {
                    session.flush();
                    session.clear();
                }
            }
            transaction.commit();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
