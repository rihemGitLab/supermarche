package org.supermarche.kata.model;

public class Apple implements Product {
    private static final String NAME = "Apple";
    private static final double PRICE = 0.20;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public double getPrice() {
        return PRICE;
    }
}