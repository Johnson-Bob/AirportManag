package com.brainacademy.airport.model;

import java.io.Serializable;

/**
 * Created by gladi on 22.11.2016.
 */
public class Statuses implements Model {
    private int statusId;
    private String status;

    public Statuses() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int getId() {
        return statusId;
    }

    @Override
    public void setId(int id) {
        statusId = id;
    }
}
