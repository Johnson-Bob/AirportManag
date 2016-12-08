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
    private Cities city;
    private Terminals terminal;
    private Statuses status;
    private Gates gate;

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

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public Terminals getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminals terminal) {
        this.terminal = terminal;
    }

    public Statuses getStatus() {
        return status;
    }

    public void setStatus(Statuses status) {
        this.status = status;
    }

    public Gates getGate() {
        return gate;
    }

    public void setGate(Gates gate) {
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
