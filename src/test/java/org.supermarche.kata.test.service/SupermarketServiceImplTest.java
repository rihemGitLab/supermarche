package org.supermarche.kata.test.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.supermarche.kata.model.*;
import org.supermarche.kata.service.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupermarketServiceImplTest {
    private SupermarketService supermarketService;
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        supermarketService = new SupermarketServiceImpl();
        cart = new ShoppingCart();
    }

    @Test
    void testScenario() {
        // Ajouter des produits au panier
        cart.addProduct(new Apple(), 4);
        cart.addProduct(new Orange(), 3);
        cart.addProduct(new Watermelon(), 5);

        // Appliquer les offres spéciales
        supermarketService.applySpecialOffer(new BuyOneGetOneFreeOffer("Apple"), cart);
        supermarketService.applySpecialOffer(new ThreeForTwoOffer("Watermelon"), cart);

        // Calculer le prix total
        double totalPrice = supermarketService.calculateTotalPrice(cart);

        // Vérifier les quantités des produits dans le panier après l'application des offres spéciales
        assertEquals(2, cart.getProductCount("Apple")); // 2 pommes devraient être dans le panier
        assertEquals(4, cart.getProductCount("Watermelon")); // 4 pastèques devraient être dans le panier

        // Vérifier que le prix total est correct
        assertEquals(5.1, totalPrice); // Le prix total devrait être de 6.30€
    }
}
