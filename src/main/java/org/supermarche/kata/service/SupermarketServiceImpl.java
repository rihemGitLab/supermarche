package org.supermarche.kata.service;
import org.supermarche.kata.model.*;

import java.util.Map;

public class SupermarketServiceImpl implements SupermarketService {
    public void applySpecialOffer(SpecialOffer offer, ShoppingCart cart) {
        offer.applyOffer(cart);
    }

    @Override
    public double calculateTotalPrice(ShoppingCart cart) {
        if (cart == null) {
            throw new IllegalArgumentException("Le panier ne peut pas être null.");
        }

        return cart.getItems().entrySet().stream()
                .mapToDouble(entry -> {
                    Product product = entry.getKey();
                    int quantity = entry.getValue();
                    return product.getPrice() * quantity;
                })
                .sum();
    }
}
