package org.example.admin.beans.geography;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.application.domain.entity.geography.City;
import org.example.service.infrastructure.transformation.ITransformable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * {@link CityBean} is value holder of the city data
 * for admin project
 *
 * @author Kul'baka Alex
 * @see City
 */
@ManagedBean(name = "currentCity")
@ViewScoped
@Getter
@Setter
@ToString
public final class CityBean implements ITransformable<City> {

    private long id;
    private String name;
    private String district;
    private String region;

    /**
     * Clear the input fields
     */
    public final void clear() {
        setId(0);
        setName("");
        setDistrict("");
        setRegion("");
    }

    public final void update(final City city) {
        setName(city.getName());
        setDistrict(city.getDistrict());
        setRegion(city.getRegion());
        setId(city.getId());
    }

    @Override
    public void transform(final City city) {
        /*NOP*/
    }

    @Override
    public City unTransform(final City city) {
        return city;
    }
}
