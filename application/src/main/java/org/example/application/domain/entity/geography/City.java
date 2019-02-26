package org.example.application.domain.entity.geography;

import org.example.application.domain.entity.base.AuditEntity;
import org.example.application.domain.entity.enums.StationType;
import org.example.application.domain.entity.valueobject.Coordinates;
import org.example.application.infrastructure.util.common.CommonUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;

/**
 * main locality that contains transport stations
 * domain model pattern
 *
 * @author Kul'baka Alex
 */
@Entity
@Table(name = "CITIES")
@NamedQueries({@NamedQuery(name = "City.DELETE_ALL_QUERY", query = "delete from City")})
public final class City extends AuditEntity implements Serializable {

    private static final long serialVersionUID = -5651833919277340882L;

    public static final String DELETE_ALL_QUERY = "";

    private String name;
    /**
     * Name of the district where city is placed
     */
    private String district;
    /**
     * Name of the region where district is located.
     * Region is top-level area in the country
     */
    private String region;
    /**
     * Set of transport stations that is linked to this
     * we should't store duplicates
     */
    private Set<Station> stations;

    /**
     * City coordinates
     */
    private Coordinates coordinates;

    public City() {
    }

    public static void main(String[] args) {
        System.out.println(TimeZone.getDefault().getDisplayName());
        System.out.println(TimeZone.getDefault().getID());
        System.out.println(TimeZone.getDefault().toZoneId());
    }

    public City(final String name) {
        this.name = name;
    }

    /**
     * Adds specified station to the city station list
     */
    public Station addStation(final StationType stationType) {
        Objects.requireNonNull(stationType, "type of station can't be null");
        if (stations == null) {
            stations = new HashSet<>();
        }
        final Station station = new Station(stationType, this);
        stations.add(station);
        return station;
    }

    public void removeStation(final Station wasteStation) {
        Objects.requireNonNull(wasteStation, "remove station should't be null");
        if (stations == null) {
            throw new IllegalArgumentException("to remove station, first add it to collection");
        }
        stations.remove(wasteStation);
    }

    /**
     * @return unmodifiable collections of stations
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city",
            orphanRemoval = true, cascade = CascadeType.ALL)
    public Set<Station> getStations() {
        return CommonUtil.getUnmodifiableSet(stations);
    }

    @Size(min = 2, max = 32)
    @NotNull
    @Column(name = "CITY_NAME", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    @Column(name = "DISTRICT", nullable = false, length = 32)
    public String getDistrict() {
        return district;
    }

    @Column(name = "REGION", nullable = false, length = 32)
    public String getRegion() {
        return region;
    }

    @Embedded
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public int showStationsCount() {
        return stations.size();
    }

    private void setName(final String name) {
        this.name = name;
    }

    public void setDistrict(final String district) {
        this.district = district;
    }

    public void setRegion(final String region) {
        this.region = region;
    }

    private void setStations(final Set<Station> stations) {
        this.stations = stations;
    }

    private void setCoordinates(final Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        City city = (City) o;
        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
