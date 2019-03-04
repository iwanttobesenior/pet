package org.example.admin.beans;

/**
 * Static info for test
 */
public final class CityBean {

    private String name;
    private String district;
    private String region;

    public CityBean() {
    }

    public CityBean(final String name, final String district, final String region) {
        this.name = name;
        this.district = district;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public String getRegion() {
        return region;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
