package com.brainacademy.airport.model;

import java.io.Serializable;

/**
 * Created by gladi on 22.11.2016.
 */
public class Nationalities implements Serializable {
    private int natId;
    private String nationality;

    public Nationalities() {
    }

    public int getNatId() {
        return natId;
    }

    public void setNatId(int natId) {
        this.natId = natId;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
