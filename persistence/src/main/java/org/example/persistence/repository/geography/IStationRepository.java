package org.example.persistence.repository.geography;

import org.example.application.domain.entity.geography.Station;
import org.example.application.domain.search.bycriteria.impl.StationCriteriaImpl;

import java.util.List;

/**
 * Repository API for {@link org.example.application.domain.entity.geography.Station}
 *
 * @author Kul'baka Alex
 */
public interface IStationRepository {

    /**
     * Find all {@code Station} that correspond to given criteria
     */
    List<Station> findAllByCriteria(final StationCriteriaImpl stationCriteria);
}
