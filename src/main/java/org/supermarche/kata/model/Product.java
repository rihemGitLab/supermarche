package org.supermarche.kata.model;

public class Product {
    private final ProductName name;
    private final double price;

    public Product(ProductName name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters
    public ProductName getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

