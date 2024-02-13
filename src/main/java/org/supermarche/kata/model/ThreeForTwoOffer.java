package org.supermarche.kata.model;


public class ThreeForTwoOffer implements SpecialOffer {
    private String productName;

    public ThreeForTwoOffer(ProductName productName) {
        this.productName = String.valueOf(productName);
    }


    @Override
    public void applyOffer(ShoppingCart cart) {
        int count = cart.getProductCount(ProductName.valueOf(productName));
        int discountedItems = count / 3; // Calcul du nombre d'articles éligibles à la réduction
        int itemsToPay = count - discountedItems; // Calcul du nombre d'articles que le client doit payer
        cart.setProductCount(ProductName.valueOf(productName), itemsToPay); // Mise à jour de la quantité dans le panier
    }

}
