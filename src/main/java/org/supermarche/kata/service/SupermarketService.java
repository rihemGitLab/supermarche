package org.supermarche.kata.service;

import org.supermarche.kata.model.ShoppingCart;

import org.supermarche.kata.model.*;

public interface SupermarketService {
    void applySpecialOffer(SpecialOffer offer, ShoppingCart cart);
    double calculateTotalPrice(ShoppingCart cart);
}
