package com.brainacademy.airport.model;

/**
 * Created by gladi on 22.11.2016.
 */
public class Prices implements Model {
    private int pricesId;
    private int flight;
    private int classFlight;
    private float price;

    public Prices() {
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
