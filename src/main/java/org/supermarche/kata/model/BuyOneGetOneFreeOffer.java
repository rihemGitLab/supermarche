package org.supermarche.kata.model;

import org.supermarche.kata.model.*;

public class BuyOneGetOneFreeOffer implements SpecialOffer {
    private final String productName;

    public BuyOneGetOneFreeOffer(String productName) {
        this.productName = productName;
    }

    @Override
    public void applyOffer(ShoppingCart cart) {
        int count = cart.getProductCount(productName);
        int freeItems = count / 2;

        // Get the existing Product instance from the cart
        Product product = cart.getProductByName(productName);
        cart.addProduct(product, freeItems);
    }

}
