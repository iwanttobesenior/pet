package org.example.admin.beans;

import org.example.application.domain.entity.geography.City;

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
public final class CityBean extends City {
}
