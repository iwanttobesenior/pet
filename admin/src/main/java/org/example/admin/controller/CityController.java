package org.example.admin.controller;

import org.example.admin.beans.CityBean;
import org.example.application.domain.entity.geography.City;
import org.example.service.infrastructure.cdi.annotation.DatabaseSourceCityServiceImpl;
import org.example.service.infrastructure.cdi.annotation.SimpleTransformerImpl;
import org.example.service.infrastructure.transformation.ITransformer;
import org.example.service.service.ICityService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Managed bean for represent info about {City}'s
 * {@code @Named} instead {@code ManagedBean} in order to put the bean under control CDI
 *
 * @author Kul'baka Alex
 */
@Named
@ApplicationScoped
public class CityController {

    private final ICityService cityService;
    private final ITransformer transformer;

    @Inject
    public CityController(final @DatabaseSourceCityServiceImpl ICityService cityService,
                          final @SimpleTransformerImpl ITransformer transformer) {
        this.cityService = cityService;
        this.transformer = transformer;
    }

    public List<City> getCities() {
        return cityService.findCities();
    }

    public void saveCity(final CityBean cityBean) {
        final var city = transformer.unTransform(cityBean, City.class);
        cityService.saveCity(city);
    }

    public void update(final City city, final CityBean cityBean) {
        transformer.transform(city, cityBean);
    }

    public void deleteById(final long cityId) {
        // TODO: 11.03.2019 log
        cityService.deleteById(cityId);
    }
}
