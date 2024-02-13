package org.supermarche.kata.test.model;

import org.junit.jupiter.api.Test;
import org.supermarche.kata.model.BuyOneGetOneFreeOffer;
import org.supermarche.kata.model.Product;
import org.supermarche.kata.model.ProductName;
import org.supermarche.kata.model.ShoppingCart;

import static org.mockito.Mockito.*;

class BuyOneGetOneFreeOfferTest {

    @Test
    void testApplyOfferWithEvenItemCount() {
        ShoppingCart cart = mock(ShoppingCart.class);

        ProductName productName = ProductName.APPLE;
        int itemCount = 4;

        when(cart.getProductCount(productName)).thenReturn(itemCount);
        when(cart.getProductByName(productName)).thenReturn(new Product(productName, 0.20));

        BuyOneGetOneFreeOffer offer = new BuyOneGetOneFreeOffer(productName);

        offer.applyOffer(cart);

        // Vérifier que la méthode addProduct du panier est appelée avec les paramètres attendus
        verify(cart).addProduct(any(Product.class), eq(2));
    }

    @Test
    void testApplyOfferWithOddItemCount() {
        ShoppingCart cart = mock(ShoppingCart.class);

        ProductName productName = ProductName.APPLE;
        int itemCount = 5;

        when(cart.getProductCount(productName)).thenReturn(itemCount);
        when(cart.getProductByName(productName)).thenReturn(new Product(productName, 0.20));

        BuyOneGetOneFreeOffer offer = new BuyOneGetOneFreeOffer(productName);

        offer.applyOffer(cart);

        // Vérifier que la méthode addProduct du panier est appelée avec les paramètres attendus
        verify(cart).addProduct(any(Product.class), eq(2));
    }

    @Test
    void testApplyOfferWithNoProduct() {
        ShoppingCart cart = mock(ShoppingCart.class);

        ProductName productName = ProductName.APPLE;

        when(cart.getProductCount(productName)).thenReturn(0);

        BuyOneGetOneFreeOffer offer = new BuyOneGetOneFreeOffer(productName);

        offer.applyOffer(cart);

        // Vérifier que la méthode addProduct du panier n'est pas appelée
        verify(cart, never()).addProduct(any(Product.class), anyInt());
    }
}
