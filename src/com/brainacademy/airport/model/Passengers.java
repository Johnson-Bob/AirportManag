package com.brainacademy.airport.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by gladi on 22.11.2016.
 */
public class Passengers implements Model {
    private int passId;
    private String firstName;
    private String secondName;
    private Nationalities nationality;
    private String passport;
    private Date birthday;
    private Sexes sex;

    public Passengers() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Nationalities getNationality() {
        return nationality;
    }

    public void setNationality(Nationalities nationality) {
        this.nationality = nationality;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Sexes getSex() {
        return sex;
    }

    public void setSex(Sexes sex) {
        this.sex = sex;
    }

    @Override
    public int getId() {
        return passId;
    }

    @Override
    public void setId(int id) {
        passId = id;
    }
}
