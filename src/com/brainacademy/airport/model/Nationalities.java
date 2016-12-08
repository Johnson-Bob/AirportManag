package com.brainacademy.airport.model;

import java.io.Serializable;

/**
 * Created by gladi on 22.11.2016.
 */
public class Nationalities implements Model {
    private int natId;
    private String nationality;

    public Nationalities() {
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public int getId() {
        return natId;
    }

    @Override
    public void setId(int id) {
        natId = id;
    }
}
