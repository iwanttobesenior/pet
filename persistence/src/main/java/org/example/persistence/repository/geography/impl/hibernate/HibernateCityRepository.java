package org.example.persistence.repository.geography.impl.hibernate;

import org.example.application.domain.entity.geography.City;
import org.example.application.domain.entity.geography.Station;
import org.example.persistence.configuration.SessionFactoryBuilder;
import org.example.persistence.infrastructure.cdi.DatabaseSourceHibernateImpl;
import org.example.persistence.repository.base.BaseHibernateRepository;
import org.example.persistence.repository.geography.ICityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import static org.example.application.infrastructure.util.reflection.ReflectionUtil.getCurrentClassName;

/**
 * Implementation of {@link ICityRepository} by hibernate provider
 *
 * @author Kul'baka Alex
 * @see SessionFactoryBuilder
 */
@Named
@DatabaseSourceHibernateImpl
public final class HibernateCityRepository extends BaseHibernateRepository implements ICityRepository {

    private static final Logger logger = LoggerFactory.getLogger(getCurrentClassName());

    @Inject
    public HibernateCityRepository(final SessionFactoryBuilder factoryBuilder) {
        super(factoryBuilder);
    }

    @Override
    public void save(final City city) {
        executeWithTransaction(session -> session.saveOrUpdate(city));
    }

    @Override
    public City findById(final long cityId) {
        return executeWithOutTransaction(session -> session.find(City.class, cityId));
    }

    @Override
    public void deleteById(final long cityId) {
        executeWithTransaction(session -> {
            final City city = session.find(City.class, cityId);
            if (city != null) {
                session.delete(city);
            }
        });
    }

    @Override
    public List<City> findAll() {
        return executeWithOutTransaction(session -> session.createNamedQuery(City.FIND_ALL_QUERY, City.class)
                .list());
    }

    @Override
    public void deleteAll() {
        executeWithTransaction(session -> {
            session.createNamedQuery(Station.DELETE_ALL_QUERY).executeUpdate();
            final int deleted = session.createNamedQuery(City.DELETE_ALL_QUERY).executeUpdate();
            logger.debug("deleted {} cities", deleted);
        });
    }

    @Override
    public void saveAll(final List<City> cities) {
        executeWithTransaction(session -> {
            final Integer batchSize = session.getJdbcBatchSize();
            for (int i = 0; i < cities.size(); i++) {
                if (i % batchSize == 0 || i == cities.size() - 1) {
                    session.flush();
                    session.clear();
                }
            }
        });
    }
}
