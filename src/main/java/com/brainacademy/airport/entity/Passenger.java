package com.brainacademy.airport.entity;

import com.brainacademy.airport.dao.PersistException;

import java.sql.Date;

/**
 * Created by gladi on 22.11.2016.
 */
public class Passenger extends Entity {
    public enum Gender{MALE, FEMALE};
    private String firstName;
    private String secondName;
    private int nationality;
    private String passport;
    private Date birthday;
    private Gender gender;

    public Passenger() {
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

    public int getNationality() {
        return nationality;
    }

    public void setNationality(int nationality) {
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

    public String getGender() {
        return gender.name();
    }

    public void setGender(String gender) throws PersistException {
        try {
            this.gender = Gender.valueOf(gender);
        }catch (IllegalArgumentException | NullPointerException e){
            throw new PersistException(e);
        }

    }
}
