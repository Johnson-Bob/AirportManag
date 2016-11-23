package com.brainacademy.airport.model;

import java.io.Serializable;

/**
 * Created by gladi on 22.11.2016.
 */
public class Cities implements Serializable {
    private int cityId;
    private String name;

    public Cities() {
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
