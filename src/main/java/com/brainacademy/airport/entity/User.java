package com.brainacademy.airport.entity;

/**
 * Created by gladi on 22.11.2016.
 */
public class User extends Entity {
    private String name;
    private String password;
    private boolean staff;

    public User() {
    }

    public User(String name, String password, boolean staff) {
        this.name = name;
        this.password = password;
        this.staff = staff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStaff() {
        return staff;
    }

    public void setStaff(boolean staff) {
        this.staff = staff;
    }
}
