package com.brainacademy.airport.entity;

/**
 * Created by gladi on 08.12.2016.
 */
public class Ticket extends Entity {
    private int passenger;
    private int flight;
    private int classFlight;

    public Ticket() {
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    public int getFlight() {
        return flight;
    }

    public void setFlight(int flight) {
        this.flight = flight;
    }

    public int getClassFlight() {
        return classFlight;
    }

    public void setClassFlight(int classFlight) {
        this.classFlight = classFlight;
    }
}
