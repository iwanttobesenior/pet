package org.example.persistence.repository.geography.impl.hibernate;

import org.apache.commons.lang3.StringUtils;
import org.example.application.domain.entity.geography.Station;
import org.example.application.domain.search.bycriteria.impl.StationCriteriaImpl;
import org.example.persistence.configuration.SessionFactoryBuilder;
import org.example.persistence.repository.geography.IStationRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link IStationRepository}
 *
 * @author Kul'bala Alex
 */
public class HibernateStationRepository implements IStationRepository {

    private final SessionFactory sessionFactory;

    @Inject
    public HibernateStationRepository(final SessionFactoryBuilder sessionFactoryBuilder) {
        this.sessionFactory = sessionFactoryBuilder.getSessionFactory();
    }

    @Override
    public List<Station> findAllByCriteria(final StationCriteriaImpl stationCriteria) {
        Session session = sessionFactory.openSession();
        try (session) {
            var cb = session.getCriteriaBuilder();
            var cq = cb.createQuery(Station.class);

            var from = cq.from(Station.class);

            List<Predicate> predicates = new ArrayList<>();

            if (stationCriteria.getStationType() != null) {
                predicates.add(cb.equal(from.get(Station.FIELD_TRANSPORT_TYPE), stationCriteria.getStationType().name()));
            }
            if (!StringUtils.isEmpty(stationCriteria.getCityName())) {
                predicates.add(cb.equal(from.get(Station.FIELD_CITY), stationCriteria.getCityName()));
            }

            cq.select(from).where(predicates.toArray(new Predicate[]{}));

            Query<Station> query = session.createQuery(cq);

            return query.getResultList();
        }
    }
}
