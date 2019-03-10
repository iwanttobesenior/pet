package org.example.admin.controller;

import org.example.admin.beans.CityBean;
import org.example.application.domain.entity.geography.City;
import org.example.service.infrastructure.cdi.DatabaseSourceCityServiceImpl;
import org.example.service.service.ICityService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
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

    @Inject
    public CityController(final @DatabaseSourceCityServiceImpl ICityService cityService) {
        this.cityService = cityService;
    }

    public List<City> getCities() {
        return cityService.findCities();
    }

    public void saveCity(final CityBean cityBean) {
        final var newCity = new City();
        newCity.setName(cityBean.getName());
        newCity.setDistrict(cityBean.getDistrict());
        newCity.setRegion(cityBean.getRegion());
        cityService.saveCity(newCity);
    }
}
