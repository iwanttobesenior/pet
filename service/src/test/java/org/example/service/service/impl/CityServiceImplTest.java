package org.example.service.service.impl;

import org.example.application.domain.entity.geography.City;
import org.example.persistence.repository.geography.impl.inmemory.InMemoryICityRepositoryImpl;
import org.example.service.service.geography.ICityService;
import org.example.service.service.geography.impl.CityServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CityServiceImplTest {

    private ICityService cityService;

    @Before
    public void init() {
        this.cityService = new CityServiceImpl(new InMemoryICityRepositoryImpl());
    }

    @Test
    public void testNoDataAtStartThenReturnEmptyCollections() {
        List<City> cities = cityService.findCities();

        assertTrue(cities.isEmpty());
    }

    @Test
    public void testSaveNewCity_Success() {
        final City city = new City("Montreal");

        List<City> cities = cityService.findCities();
        assertFalse(cities.contains(city));

        cityService.saveCity(city);
        assertTrue(cities.contains(city));
    }

    @Test(expected = NullPointerException.class)
    public void testAddNotValidCityAsNull_Fail() {
        final City city = null;

        cityService.saveCity(city);

        fail();
    }

    @Test
    public void testFindCitiesThenReturnValidAmount() {
        final City frankfurt = new City("Frankfurt am Main");
        final City paris = new City("Paris ");
        final City basilea = new City("Basilea");
        final City bucuresti = new City("Bucuresti");
        final City gdansk = new City("Gdansk ");

        List<City> shouldBeEmpty = cityService.findCities();
        assertTrue(shouldBeEmpty.isEmpty());

        cityService.saveCity(frankfurt);
        cityService.saveCity(paris);
        cityService.saveCity(basilea);
        cityService.saveCity(bucuresti);
        cityService.saveCity(gdansk);

        List<City> cities = cityService.findCities();
        assertEquals(5, cities.size());
    }
}
