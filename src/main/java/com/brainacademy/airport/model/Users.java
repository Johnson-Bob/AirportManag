package com.brainacademy.airport.model;

/**
 * Created by gladi on 22.11.2016.
 */
public class Users implements Model {
    private int userId;
    private String name;
    private String password;
    private boolean staff;

    public Users() {
    }

    public Users(String name, String password, boolean staff) {
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

    @Override
    public int getId() {
        return userId;
    }

    @Override
    public void setId(int id) {
        userId = id;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", staff=" + staff +
                '}';
    }
}
