package org.example.service.service.impl;

import org.example.application.domain.entity.geography.City;
import org.example.application.domain.entity.geography.Station;
import org.example.application.domain.search.bycriteria.impl.StationCriteriaImpl;
import org.example.application.domain.search.pagenation.IRangeCriteria;
import org.example.application.infrastructure.exception.uncheked.execution.InvalidArgumentException;
import org.example.application.infrastructure.exception.uncheked.execution.ValidationException;
import org.example.persistence.infrastructure.cdi.DatabaseSourceHibernateImpl;
import org.example.persistence.repository.geography.ICityRepository;
import org.example.service.infrastructure.cdi.annotation.DatabaseSourceCityServiceImpl;
import org.example.service.service.ICityService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * implementation of {@link ICityService}
 *
 * @author Kul'baka Alex
 */
@Named
@DatabaseSourceCityServiceImpl
public final class CityServiceImpl implements ICityService {

    private final ICityRepository cityRepository;
    private final Validator validator;

    @Inject
    public CityServiceImpl(final @DatabaseSourceHibernateImpl ICityRepository cityRepository) {
        this.cityRepository = cityRepository;

        var validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Override
    public List<City> findCities() {
        return cityRepository.findAll();
    }

    @Override
    public void saveCity(final City city) {
        var constraintViolations = validator.validate(city);
        System.out.println(constraintViolations.size());
        if (!constraintViolations.isEmpty()) {
            throw new ValidationException
                    ("City - " + city + " validation failure : " + constraintViolations);
        }
        cityRepository.save(city);
    }

    /**
     * @throws InvalidArgumentException if id <= 0 (which is unacceptable value for id.)
     */
    @Override
    public Optional<City> findCityById(final long id) {
        return Optional.ofNullable(cityRepository.findById(id));
    }

    /**
     * @return List of stations. Or, empty {@code List} if not one station does exist
     */
    @Override
    public List<Station> searchStationByCriteria(final StationCriteriaImpl stationCriteria,
                                                 final IRangeCriteria rangeCriteria) {
        final var stations = new HashSet<Station>();
        cityRepository.findAll().forEach(city -> stations.addAll(city.getStations()));

        return stations.stream().filter(station -> station.match(stationCriteria)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(long cityId) {
        cityRepository.deleteById(cityId);
    }

    @Override
    public void saveAll(List<City> cities) {
        cityRepository.saveAll(cities);
    }

    @Override
    public void deleteAll() {
        cityRepository.deleteAll();
    }
}
