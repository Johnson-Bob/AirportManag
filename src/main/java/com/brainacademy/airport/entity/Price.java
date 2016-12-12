package com.brainacademy.airport.entity;

/**
 * Created by gladi on 22.11.2016.
 */
public class Price extends Entity {
    private int flight;
    private int classFlight;
    private float price;

    public Price() {
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
}
