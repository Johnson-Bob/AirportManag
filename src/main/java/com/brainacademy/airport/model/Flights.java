package com.brainacademy.airport.model;

import java.sql.Date;

/**
 * Created by gladi on 22.11.2016.
 */
public class Flights implements Model {
    private int flightId;
    private String type;
    private Date date;
    private String number;
    private int city;
    private int terminal;
    private int status;
    private int gate;

    public Flights() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public int getId() {
        return flightId;
    }

    @Override
    public void setId(int id) {
        flightId = id;
    }
}
