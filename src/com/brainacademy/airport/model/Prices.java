package com.brainacademy.airport.model;

/**
 * Created by gladi on 22.11.2016.
 */
public class Prices implements Model {
    private int pricesId;
    private Flights flight;
    private Classes classFlight;
    private float price;

    public Prices() {
    }

    public Flights getFlight() {
        return flight;
    }

    public void setFlight(Flights flight) {
        this.flight = flight;
    }

    public Classes getClassFlight() {
        return classFlight;
    }

    public void setClassFlight(Classes classFlight) {
        this.classFlight = classFlight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public int getId() {
        return pricesId;
    }

    @Override
    public void setId(int id) {
        pricesId = id;
    }
}
