package com.brainacademy.airport.model;

/**
 * Created by gladi on 22.11.2016.
 */
public class Cities implements Model {
    private int cityId;
    private String name;

    public Cities() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return cityId;
    }

    @Override
    public void setId(int id) {
        cityId = id;
    }
}
