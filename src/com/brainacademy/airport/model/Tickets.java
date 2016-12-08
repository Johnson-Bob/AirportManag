package com.brainacademy.airport.model;

/**
 * Created by gladi on 08.12.2016.
 */
public class Tickets implements Model {
    private int ticketId;
    private Passengers passenger;
    private Flights flight;
    private Classes classes;

    public Tickets() {
    }

    public Passengers getPassenger() {
        return passenger;
    }

    public void setPassenger(Passengers passenger) {
        this.passenger = passenger;
    }

    public Flights getFlight() {
        return flight;
    }

    public void setFlight(Flights flight) {
        this.flight = flight;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
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
