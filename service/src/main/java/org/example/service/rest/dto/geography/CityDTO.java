package org.example.service.rest.dto.geography;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.example.service.rest.dto.base.AbstractDTO;
import org.example.application.domain.entity.geography.City;

/**
 * DTO class for {@link org.example.application.domain.entity.geography.City}
 * that will be send to client instead complete and excess original
 *
 * @author Kul'baka Alex
 */
@ApiModel(description = "City to book and purchase tickets")
public class CityDTO extends AbstractDTO<City> {

    private String name;
    private String district;
    private String region;

    public CityDTO() {
    }

    @ApiModelProperty(name = "Name of city", required = true)
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @ApiModelProperty(name = "Name of the city's district.Can be empty if city is region center", required = false)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(final String district) {
        this.district = district;
    }

    @ApiModelProperty(name = "Name of the city's region", required = true)
    public String getRegion() {
        return region;
    }

    public void setRegion(final String region) {
        this.region = region;
    }
}
