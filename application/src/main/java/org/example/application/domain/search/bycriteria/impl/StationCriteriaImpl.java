package org.example.application.domain.search.bycriteria.impl;


import org.example.application.domain.entity.enums.StationType;
import org.example.application.domain.entity.valueobject.Address;
import org.example.application.domain.entity.valueobject.Coordinates;
import org.example.application.infrastructure.util.check.Verifications;

/**
 * Filtering criteria for search stations operation
 *
 * @author Kul'baka Alex
 */

// TODO: 04.02.2019 if multiply criteria
public final class StationCriteriaImpl {

    private String cityName;
    private StationType stationType;
    private Address address;
    private Coordinates coordinates;

    public static StationCriteriaImpl byCityName(final String cityName) {
        return new StationCriteriaImpl(cityName);
    }

    private StationCriteriaImpl(final String cityName) {
        Verifications.verifyArg(cityName != null, "to search by criteria , name should be initialized");
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(final String cityName) {
        this.cityName = cityName;
    }

    public StationType getStationType() {
        return stationType;
    }

    public void setStationType(final StationType stationType) {
        this.stationType = stationType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(final Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
