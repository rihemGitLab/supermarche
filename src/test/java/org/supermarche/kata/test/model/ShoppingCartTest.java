package org.supermarche.kata.test.model;

import org.junit.jupiter.api.Test;
import org.supermarche.kata.model.Product;
import org.supermarche.kata.model.ProductName;
import org.supermarche.kata.model.ShoppingCart;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void testAddProductWithValidArguments() {
        ShoppingCart cart = new ShoppingCart();

        Product product = new Product(ProductName.APPLE, 0.20);
        cart.addProduct(product, 3);

        // Vérifier que le produit a été ajouté avec la bonne quantité
        assertEquals(3, cart.getProductCount(ProductName.APPLE));
    }

    @Test
    void testAddProductWithNullProduct() {
        ShoppingCart cart = new ShoppingCart();

        // Ajouter un produit null
        assertThrows(IllegalArgumentException.class, () -> cart.addProduct(null, 3));
    }

    @Test
    void testAddProductWithNegativeQuantity() {
        ShoppingCart cart = new ShoppingCart();

        // Ajouter un produit avec une quantité négative
        Product product = new Product(ProductName.APPLE, 0.20);
        assertThrows(IllegalArgumentException.class, () -> cart.addProduct(product, -1));
    }

    @Test
    void testGetProductByNameWithExistingProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product(ProductName.APPLE, 0.20);
        cart.addProduct(product, 3);

        // Récupérer le produit par son nom
        assertEquals(product, cart.getProductByName(ProductName.APPLE));
    }

    @Test
    void testSetProductCountWithExistingProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product(ProductName.APPLE, 0.20);
        cart.addProduct(product, 3);

        cart.setProductCount(ProductName.APPLE, 5);

        // Vérifier que la quantité du produit a été mise à jour
        assertEquals(5, cart.getProductCount(ProductName.APPLE));
    }

    @Test
    void testGetItems() {
        ShoppingCart cart = new ShoppingCart();
        Product product1 = new Product(ProductName.APPLE, 0.5);
        Product product2 = new Product(ProductName.ORANGE, 0.7);
        cart.addProduct(product1, 2);
        cart.addProduct(product2, 3);
        assertEquals(2, cart.getItems().size());
        assertTrue(cart.getItems().containsKey(product1));
        assertTrue(cart.getItems().containsKey(product2));
        assertEquals(2, cart.getItems().get(product1));
        assertEquals(3, cart.getItems().get(product2));
    }
}
