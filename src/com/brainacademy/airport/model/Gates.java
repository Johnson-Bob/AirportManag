package com.brainacademy.airport.model;

/**
 * Created by gladi on 22.11.2016.
 */
public class Gates implements Model {
    private int gateId;
    private int number;

    public Gates() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int getId() {
        return gateId;
    }

    @Override
    public void setId(int id) {
        gateId = id;
    }
}
