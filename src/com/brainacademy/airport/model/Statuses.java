package com.brainacademy.airport.model;

import java.io.Serializable;

/**
 * Created by gladi on 22.11.2016.
 */
public class Statuses implements Serializable {
    private int statusId;
    private String status;

    public Statuses() {
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
