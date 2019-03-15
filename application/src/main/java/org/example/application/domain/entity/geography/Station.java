package org.example.application.domain.entity.geography;

import org.apache.commons.lang3.StringUtils;
import org.example.application.domain.entity.base.AuditEntity;
import org.example.application.domain.entity.enums.StationType;
import org.example.application.domain.entity.valueobject.Address;
import org.example.application.domain.entity.valueobject.Coordinates;
import org.example.application.domain.search.bycriteria.impl.StationCriteriaImpl;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * Station where passengers can get off or take specific kind
 * of transport. Multiple stationts compose route of the trip.
 *
 * @author Kul'baka Alex
 */
@Entity
@Table(name = "STATIONS")
@NamedQueries({@NamedQuery(name = "Station.DELETE_ALL_QUERY", query = "delete from Station")})
public final class Station extends AuditEntity implements Serializable {

    public static final String FIELD_TRANSPORT_TYPE = "stationType";

    public static final String FIELD_CITY = "city";

    private static final long serialVersionUID = 4243193847902815389L;
    /**
     * The exact address of station location
     *
     * @see Address
     */
    private Address address;
    /**
     * More precise location
     *
     * @see Coordinates
     */
    private Coordinates coordinates;
    /**
     * Type of station
     *
     * @see StationType
     */
    private StationType stationType;
    /**
     * Locality wherein {@code this} is located
     */
    private City city;

    public Station() {
    }

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

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CITY_ID")
    public City getCity() {
        return city;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "STATION_TYPE", nullable = false)
    public StationType getStationType() {
        return stationType;
    }

    @Embedded
    public Address getAddress() {
        return address;
    }

    @Embedded
    public Coordinates getCoordinates() {
        return coordinates;
    }

    private void setAddress(final Address address) {
        this.address = address;
    }

    private void setCoordinates(final Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    private void setCity(final City city) {
        this.city = city;
    }

    private void setStationType(final StationType stationType) {
        this.stationType = stationType;
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
