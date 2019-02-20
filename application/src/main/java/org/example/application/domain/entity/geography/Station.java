package org.example.application.domain.entity.geography;

import org.apache.commons.lang3.StringUtils;
import org.example.application.domain.entity.base.AuditEntity;
import org.example.application.domain.entity.enums.StationType;
import org.example.application.domain.entity.valueobject.Address;
import org.example.application.domain.entity.valueobject.Coordinates;
import org.example.application.domain.search.bycriteria.impl.StationCriteriaImpl;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Station where passengers can get off or take specific kind
 * of transport. Multiple stationts compose route of the trip.
 *
 * @author Kul'baka Alex
 */
@Entity
@Table(name = "STATIONS")
public final class Station extends AuditEntity {

    private Address address;
    private Coordinates coordinates;
    private final StationType stationType;
    private final City city;

    public Station(final StationType type, final City city) {
        this.stationType = type;
        this.city = city;
    }

    public boolean match(final StationCriteriaImpl stationCriteria) {
        Objects.requireNonNull(stationCriteria, "Station criteria is't initialized");
        if (!StringUtils.isEmpty(stationCriteria.getCityName())) {
            if (!city.getName().equals(stationCriteria.getCityName())) {
                return false;
            }
        }

        if (stationCriteria.getStationType() != null) {
            if (stationType != stationCriteria.getStationType()) {
                return false;
            }
        }

        return true;
    }

    public City getCity() {
        return city;
    }

    public StationType getStationType() {
        return stationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Station station = (Station) o;
        return stationType == station.stationType &&
                Objects.equals(getCity(), station.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stationType, getCity());
    }
}
