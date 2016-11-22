package com.brainacademy.airport.model;

/**
 * Created by gladi on 22.11.2016.
 */
public class Prices {
    private int pricesId;
    private int flight;
    private int classFlight;
    private float price;

    public Prices() {
    }

    public int getPricesId() {
        return pricesId;
    }

    public void setPricesId(int pricesId) {
        this.pricesId = pricesId;
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
