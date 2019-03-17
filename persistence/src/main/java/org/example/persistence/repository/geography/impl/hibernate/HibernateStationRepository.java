package org.example.persistence.repository.geography.impl.hibernate;

import org.apache.commons.lang3.StringUtils;
import org.example.application.domain.entity.geography.Station;
import org.example.application.domain.search.bycriteria.impl.StationCriteriaImpl;
import org.example.application.infrastructure.util.transformation.ReflectionUtil;
import org.example.persistence.configuration.SessionFactoryBuilder;
import org.example.persistence.infrastructure.cdi.DatabaseSourceHibernateImpl;
import org.example.persistence.repository.base.BaseHibernateRepository;
import org.example.persistence.repository.geography.IStationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link IStationRepository}
 *
 * @author Kul'bala Alex
 */
@Named
@DatabaseSourceHibernateImpl
public class HibernateStationRepository extends BaseHibernateRepository implements IStationRepository {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtil.getCurrentClassName());

    @Inject
    public HibernateStationRepository(final SessionFactoryBuilder sessionFactoryBuilder) {
        super(sessionFactoryBuilder);
    }

    @Override
    public List<Station> findAllByCriteria(final StationCriteriaImpl stationCriteria) {
        return executeWithOutTransaction(session -> {
            final var cb = session.getCriteriaBuilder();
            final var cq = cb.createQuery(Station.class);

            final var from = cq.from(Station.class);

            final List<Predicate> predicates = new ArrayList<>();

            if (stationCriteria.getStationType() != null) {
                predicates.add(cb.equal(from.get(Station.FIELD_TRANSPORT_TYPE), stationCriteria.getStationType().name()));
            }
            if (!StringUtils.isEmpty(stationCriteria.getCityName())) {
                predicates.add(cb.equal(from.get(Station.FIELD_CITY), stationCriteria.getCityName()));
            }

            cq.select(from).where(predicates.toArray(new Predicate[]{}));

            final var query = session.createQuery(cq);

            return query.getResultList();
        });
    }
}
