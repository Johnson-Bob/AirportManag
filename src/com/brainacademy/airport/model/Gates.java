package com.brainacademy.airport.model;

import java.io.Serializable;

/**
 * Created by gladi on 22.11.2016.
 */
public class Gates implements Serializable {
    private int gateId;
    private int number;

    public Gates() {
    }

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
