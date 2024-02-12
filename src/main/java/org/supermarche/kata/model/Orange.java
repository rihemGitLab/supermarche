package org.supermarche.kata.model;

public class Orange implements Product {
    private static final String NAME = "Orange";
    private static final double PRICE = 0.50;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public double getPrice() {
        return PRICE;
    }
}