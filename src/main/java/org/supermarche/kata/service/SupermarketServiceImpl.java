package org.supermarche.kata.service;
import org.supermarche.kata.model.*;

import java.util.Map;

public class SupermarketServiceImpl implements SupermarketService {
    public void applySpecialOffer(SpecialOffer offer, ShoppingCart cart) {
        offer.applyOffer(cart);
    }

    @Override
    public double calculateTotalPrice(ShoppingCart cart) {
        double totalPrice = 0;
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += product.getPrice() * quantity;
        }
        return totalPrice;
    }
}
