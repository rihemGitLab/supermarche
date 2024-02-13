package org.supermarche.kata.test.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.supermarche.kata.model.*;
import org.supermarche.kata.service.*;

import static org.junit.jupiter.api.Assertions.*;

public class SupermarketServiceImplTest {
    private SupermarketService supermarketService;
    private ShoppingCart cart;

    private static final double APPLEPRICE = 0.20;
    private static final double ORANGEPRICE = 0.50;
    private static final double WATERMELONPRICE = 0.80;

    @BeforeEach
    void setUp() {
        supermarketService = new SupermarketServiceImpl();
        cart = new ShoppingCart();
    }

    @Test
    void testScenarioWithOffersApplied() {
        cart.addProduct(new Product(ProductName.APPLE,APPLEPRICE),4);
        cart.addProduct(new Product(ProductName.ORANGE,ORANGEPRICE), 3);
        cart.addProduct(new Product(ProductName.WATERMELON,WATERMELONPRICE), 5);

        supermarketService.applySpecialOffer(new BuyOneGetOneFreeOffer(ProductName.APPLE), cart);
        supermarketService.applySpecialOffer(new ThreeForTwoOffer(ProductName.WATERMELON), cart);

        double totalPrice = supermarketService.calculateTotalPrice(cart);

        // Vérifier les quantités des produits dans le panier après l'application des offres spéciales
        assertEquals(2, cart.getProductCount(ProductName.APPLE)); // 2 pommes devraient être dans le panier
        assertEquals(4, cart.getProductCount(ProductName.WATERMELON)); // 4 pastèques devraient être dans le panier

        // Vérifier que le prix total est correct
        assertEquals(5.1, totalPrice); // Le prix total devrait être de 5.1€

    }

    @Test
    void testAddingProductsWithNegativeOrZeroQuantity() {
        // Vérifier que l'ajout d'une quantité négative lève une exception IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> cart.addProduct(new Product(ProductName.APPLE,APPLEPRICE ),-2));

        // Vérifier que l'ajout d'une quantité de zéro ne lève pas d'exception
        assertDoesNotThrow(() -> cart.addProduct(new Product(ProductName.ORANGE, ORANGEPRICE),0));

        // Vérifier que les quantités de produits ne changent pas
        assertEquals(0, cart.getProductCount(ProductName.APPLE)); // La quantité d'Apple ne devrait pas changer
        assertEquals(0, cart.getProductCount(ProductName.ORANGE)); // La quantité d'Orange ne devrait pas changer
    }

    @Test
    void testCalculateTotalPriceWithEmptyCart() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0.0, supermarketService.calculateTotalPrice(cart));
    }
}
