package org.supermarche.kata.model;

public class BuyOneGetOneFreeOffer implements SpecialOffer {
    private final String productName;

    public BuyOneGetOneFreeOffer(ProductName productName) {
        this.productName = String.valueOf(productName);
    }

    @Override
    public void applyOffer(ShoppingCart cart) {
        int count = cart.getProductCount(ProductName.valueOf(productName));
        int freeItems = count / 2;

        // Get the existing Product instance from the cart
        Product product = cart.getProductByName(ProductName.valueOf(productName));
        cart.addProduct(product, freeItems);
    }
}
