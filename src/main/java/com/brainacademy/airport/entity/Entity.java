package com.brainacademy.airport.entity;

import java.io.Serializable;

/**
 * Created by gladi on 08.12.2016.
 */
public abstract class Entity implements Serializable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
