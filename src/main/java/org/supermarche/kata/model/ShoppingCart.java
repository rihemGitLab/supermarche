package org.supermarche.kata.model;


import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        items.put(product,  quantity);
    }

    public int getProductCount(String productName) {
        return items.entrySet().stream()
                .filter(entry -> entry.getKey().getName().equals(productName))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    public void setProductCount(String productName, int quantity) {
        Product product = items.keySet().stream()
                .filter(p -> p.getName().equals(productName))
                .findFirst().orElse(null);
        if (product != null) {
            items.put(product, quantity);
        }
    }
    public Product getProductByName(String productName) {
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            if (entry.getKey().getName().equals(productName)) {
                return entry.getKey();
            }
        }
        return null; // Retourner null si le produit n'est pas trouvé
    }
    public void applySpecialOffer(SpecialOffer offer) {
        offer.applyOffer(this);
    }
    public Map<Product, Integer> getItems() {
        return new HashMap<>(items); // Return a copy to prevent modification of the original map
    }
}
