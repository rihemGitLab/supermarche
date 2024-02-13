package org.supermarche.kata.test.model;

import org.junit.jupiter.api.Test;
import org.supermarche.kata.model.ProductName;
import org.supermarche.kata.model.ShoppingCart;
import org.supermarche.kata.model.ThreeForTwoOffer;

import static org.mockito.Mockito.*;

class ThreeForTwoOfferTest {

    @Test
    void testApplyOfferWithItemCountMultipleOfThree() {
        ShoppingCart cart = mock(ShoppingCart.class);
        ProductName productName = ProductName.APPLE;
        int itemCount = 9;
        when(cart.getProductCount(productName)).thenReturn(itemCount);

        ThreeForTwoOffer offer = new ThreeForTwoOffer(productName);
        offer.applyOffer(cart);

        verify(cart).setProductCount(productName, 6);
    }

    @Test
    void testApplyOfferWithItemCountNotMultipleOfThree() {
        ShoppingCart cart = mock(ShoppingCart.class);
        ProductName productName = ProductName.APPLE;
        int itemCount = 7;
        when(cart.getProductCount(productName)).thenReturn(itemCount);

        ThreeForTwoOffer offer = new ThreeForTwoOffer(productName);
        offer.applyOffer(cart);

        verify(cart).setProductCount(productName, 5);
    }


}
