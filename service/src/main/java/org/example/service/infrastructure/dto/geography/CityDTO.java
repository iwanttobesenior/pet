package org.example.service.infrastructure.dto.geography;

import org.example.application.domain.entity.geography.City;
import org.example.service.infrastructure.dto.base.AbstractDTO;

/**
 * DTO class for {@link org.example.application.domain.entity.geography.City}
 * that will be send to client instead complete and excess original
 *
 * @author Kul'baka Alex
 */
public class CityDTO extends AbstractDTO<City>{

    private String name;
    private String district;
    private String region;

    public CityDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(final String district) {
        this.district = district;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(final String region) {
        this.region = region;
    }
}
