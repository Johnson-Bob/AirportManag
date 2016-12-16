package com.brainacademy.airport.entity;

import com.brainacademy.airport.dao.PersistException;

import java.sql.Date;

/**
 * Created by gladi on 22.11.2016.
 */
public class Flight extends Entity {
    public enum TypeFlight{ARRIVAL, DEPARTURE}
    private TypeFlight type;
    private Date date;
    private String number;
    private int city;
    private int terminal;
    private int status;
    private int gate;

    public Flight() {
    }

    public String getType() {
        return type.name();
    }

    public void setType(String type) throws PersistException {
        try {
            this.type = TypeFlight.valueOf(type.toUpperCase());
        }catch (IllegalArgumentException | NullPointerException e){
            throw new PersistException(e);
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getTerminal() {
        return terminal;
    }

    public void setTerminal(int terminal) {
        this.terminal = terminal;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getGate() {
        return gate;
    }

    public void setGate(int gate) {
        this.gate = gate;
    }
}
