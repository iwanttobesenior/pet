package org.example.persistence.repository.geography.impl.inmemory;

import org.example.application.domain.entity.geography.City;
import org.example.application.infrastructure.util.common.CommonUtil;
import org.example.persistence.repository.geography.ICityRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * In memory implementation of {@link ICityRepository}
 *
 * @author Kul'baka Alex
 */

public final class InMemoryICityRepositoryImpl implements ICityRepository {

    /**
     * Internal list of cities
     */
    private final List<City> cities;

    private int cityCounter = 0;
    private int stationCounter = 0;

    public InMemoryICityRepositoryImpl() {
        cities = new ArrayList<>();
    }

    @Override
    public void save(final City city) {
        if (!cities.contains(city)) {
            city.setId(++cityCounter);
            cities.add(city);
        }
        city.getStations().forEach(station -> {
            if (station.getId() == 0) {
                station.setId(++stationCounter);
            }
        });
    }

    @Override
    public City findById(final long cityId) {
        return cities.stream().filter(city -> city.getId() == cityId).findFirst().orElse(null);
    }

    @Override
    public void deleteById(long cityId) {
        /*NOP*/
    }

    @Override
    public List<City> findAll() {
        return CommonUtil.getUnmodifiableList(cities);
    }

    @Override
    public void deleteAll() {
        cities.clear();
    }

    @Override
    public void saveAll(final List<City> cities) {
        cities.addAll(cities);
    }
}
