package org.example.admin.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Managed bean for represent info about {City}'s
 *
 * @author Kul'baka Alex
 */
@ManagedBean
@RequestScoped
// TODO: 04.03.2019 CDI instead or together with spring
public class CitiesBean {

    private final List<CityBean> cityBeans;

    public CitiesBean() {
        this.cityBeans = new ArrayList<>(Arrays
                .asList(
                        new CityBean("odessa", "", "odessa"),
                        new CityBean("moscow", "", "moscow"),
                        new CityBean("dnepr", "dnepr", "dnepr")
                ));
    }

    public List<CityBean> getCityBeans() {
        return cityBeans;
    }
}
