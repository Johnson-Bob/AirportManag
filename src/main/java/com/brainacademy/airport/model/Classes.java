package com.brainacademy.airport.model;

/**
 * Created by gladi on 22.11.2016.
 */
public class Classes implements Model {
    private int classId;
    private String className;

    public Classes() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public int getId() {
        return classId;
    }

    @Override
    public void setId(int id) {
        classId = id;
    }
}
