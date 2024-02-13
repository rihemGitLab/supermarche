package org.supermarche.kata.model;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ShoppingCart {
    private Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Le produit ne peut pas être null.");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("La quantité ne peut pas être négative.");
        }
        items.put(product, quantity);
    }
    public int getProductCount(ProductName productName) {
        // Vérifie si le nom du produit est null
        if (productName == null) {
            throw new IllegalArgumentException("Le nom du produit ne peut pas être null.");
        }
        return items.entrySet().stream()
                .filter(entry -> entry.getKey().getName() == productName)
                .mapToInt(Map.Entry::getValue)
                .sum();
    }



    public Product getProductByName(ProductName productName) {
        return findProductByName(productName).orElse(null);
    }

    public void setProductCount(ProductName productName, int quantity) {
        findProductByName(productName).ifPresent(product -> items.put(product, quantity));
    }

    private Optional<Product> findProductByName(ProductName productName) {
        return items.keySet().stream()
                .filter(product -> product.getName() == productName)
                .findFirst();
    }

    public Map<Product, Integer> getItems() {
        return new HashMap<>(items); // Return a copy to prevent modification of the original map
    }
}
