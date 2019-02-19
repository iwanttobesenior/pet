package org.example.service.service.impl;

import org.example.application.domain.entity.geography.City;
import org.example.application.domain.entity.geography.Station;
import org.example.application.domain.search.bycriteria.impl.StationCriteriaImpl;
import org.example.application.domain.search.pagenation.IRangeCriteria;
import org.example.application.infrastructure.exception.uncheked.execution.InvalidArgumentException;
import org.example.application.infrastructure.util.check.Verifications;
import org.example.application.infrastructure.util.common.CommonUtil;
import org.example.service.service.ICityService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * implementation of {@link ICityService}
 *
 * @author Kul'baka Alex
 */
public final class CityServiceImpl implements ICityService {

    /**
     * internal storage
     * workaround
     */
    private final List<City> cities;

    public CityServiceImpl() {
        cities = new ArrayList<>();
    }

    @Override
    public List<City> findCities() {
        return CommonUtil.getUnmodifiableList(cities);
    }

    @Override
    public void saveCity(final City city) {
        Objects.requireNonNull(city, "for save city is should be initialized");
        if (!cities.contains(city)) {
            cities.add(city);
        }
    }

    /**
     * @throws InvalidArgumentException if id <= 0 (which is unacceptable value for id.)
     */
    @Override
    public Optional<City> findCityById(final long id) {
        Verifications.checkArguments(id >= 1, "argument id " + id + " should be more than 0.");
        return cities.stream().filter(city -> city.getId() == id).findFirst();
    }

    /**
     * @return List of stations. Or, empty {@code List} if not one station does exist
     */
    @Override
    public List<Station> searchStationByCriteria(final StationCriteriaImpl stationCriteria,
                                                 final IRangeCriteria rangeCriteria) {

        var optionalByStations = cities.stream().map(City::getStations).reduce((stationSet1, stationSet2) ->
                {
                    var stations = new HashSet<Station>();
                    stations.addAll(stationSet1);
                    stations.addAll(stationSet2);
                    return stations;
                }
        );

        if (optionalByStations.isEmpty()) {
            return Collections.emptyList();
        }

        return optionalByStations.get().stream().filter(station -> station.match(stationCriteria)).collect(Collectors.toList());
    }
}
