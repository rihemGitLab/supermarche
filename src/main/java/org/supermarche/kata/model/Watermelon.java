package org.supermarche.kata.model;

public class Watermelon implements Product {
    private static final String NAME = "Watermelon";
    private static final double PRICE = 0.80;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public double getPrice() {
        return PRICE;
    }
}

