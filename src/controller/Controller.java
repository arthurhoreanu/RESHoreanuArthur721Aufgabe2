package controller;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Controller {

    private List<Product> products = new ArrayList<>();

    // CRUD Product

    /**
     * Adds product to the InMemory repository.
     * @param product
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Gets all products from the InMemory repository.
     * @return
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Updates products from the InMemory repository.
     * @param newName
     * @param newPrice
     * @param newUniverse
     */
    public void updateProduct(String inputName, String newName, int newPrice, String newUniverse) {
        for (Product product : products) {
            if (Objects.equals(product.getName(), inputName)) {
                product.setName(newName);
                product.setPrice(newPrice);
                product.setUniverse(newUniverse);
            }
        }
    }

    /**
     * Deletes products from the InMemory repository.
     * @param name
     */
    public void deleteProduct(String name) {
        products.removeIf(product -> Objects.equals(product.getName(), name));
    }

}
