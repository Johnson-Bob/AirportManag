package com.brainacademy.airport.model;

/**
 * Created by gladi on 08.12.2016.
 */
public class Tickets implements Model {
    private int ticketId;
    private int passenger;
    private int flight;
    private int classFlight;

    public Tickets() {
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

    @Override
    public int getId() {
        return ticketId;
    }

    @Override
    public void setId(int id) {
        ticketId = id;
    }
}
