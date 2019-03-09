package org.example.admin.beans;

import org.example.application.domain.entity.geography.City;
import org.example.service.infrastructure.cdi.DatabaseSourceCityServiceImpl;
import org.example.service.service.ICityService;

import javax.annotation.PostConstruct;
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
@RequestScoped
public class CitiesBean {

    private final ICityService cityService;

    @Inject
    public CitiesBean(final @DatabaseSourceCityServiceImpl ICityService cityService) {
        this.cityService = cityService;
    }

    public List<City> getCities() {
        return cityService.findCities();
    }

    @PostConstruct
    public void testLifeCycle() {
        System.out.println("!");
    }
}
