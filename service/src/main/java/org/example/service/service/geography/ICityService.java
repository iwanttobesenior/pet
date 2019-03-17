package org.example.service.service.geography;

import org.example.application.domain.entity.geography.City;
import org.example.application.domain.entity.geography.Station;
import org.example.application.domain.search.bycriteria.impl.StationCriteriaImpl;
import org.example.application.domain.search.pagenation.IRangeCriteria;

import java.util.List;
import java.util.Optional;

/**
 * Service for geographical entities {@link City}
 * Represent a facade to interaction with business logic
 *
 * @author Kul'baka Alex
 */
public interface ICityService {

    /**
     * Return list of all existing cities
     *
     * @return {@code List<City>}
     * {@code List} because sometimes we need order
     */
    List<City> findCities();

    /**
     * Saves specified city instance
     *
     * @param city
     */
    void saveCity(final City city);

    /**
     * @param id
     * @return {@code Optional} mean that method can return null
     */
    Optional<City> findCityById(final long id);

    /**
     * @return {@code List} of all the stations that match specified criteria
     */
    List<Station> searchStationByCriteria(final StationCriteriaImpl stationCriteria,
                                          final IRangeCriteria rangeCriteria);

    /**
     * Delete {@link City} with specified identifier
     *
     * @param cityId
     */
    void deleteById(final long cityId);

    /**
     * Saves all specified city instances
     * @param cities
     */
    void saveAll(final List<City> cities);

    /**
     * Removes all the cities
     */
    void deleteAll();
}
