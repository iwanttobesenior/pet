package org.example.application.domain.dto.geography;

import org.example.application.domain.dto.base.AbstractDTO;
import org.example.application.domain.entity.geography.City;

/**
 * DTO class for {@link org.example.application.domain.entity.geography.City}
 * that will be send to client instead complete and excess original
 *
 * @author Kul'baka Alex
 */
public class CityDTO extends AbstractDTO<City> {

    private String name;
    private String district;
    private String region;

    public CityDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
