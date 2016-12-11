package com.brainacademy.airport.model;

import java.io.Serializable;

/**
 * Created by gladi on 22.11.2016.
 */
public class Sexes implements Model {
    private int sexId;
    private String sex;

    public Sexes() {
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public int getId() {
        return sexId;
    }

    @Override
    public void setId(int id) {
        sexId = id;
    }
}
