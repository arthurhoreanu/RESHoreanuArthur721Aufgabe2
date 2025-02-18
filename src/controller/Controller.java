package controller;

import model.*;
import model.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Controller {

    private List<Product> products = new ArrayList<>();
    private List<Character> characters = new ArrayList<>();

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

    // CRUD Character

    /**
     * Adds character to the InMemory repository.
     * @param character
     */
    public void addCharacter(model.Character character) {
        for( Character characterFromList : characters) {
            if(characterFromList.getId() == character.getId()) {
                throw new IllegalArgumentException("Character already exists");
            }
        }
        characters.add(character);
    }

    /**
     * Gets all characters from the InMemory repository.
     * @return
     */
    public List<model.Character> getCharacterList() {
        return characters;
    }

    /**
     * Updates characters from the InMemory repository.
     * @param id
     * @param newName
     * @param newRegion
     */
    public void updateCharacter(int id, String newName, String newRegion) {
        for (model.Character character : characters) {
            if (character.getId() == id) {
                character.setName(newName);
                character.setRegion(newRegion);
            }
        }
    }

    /**
     * Deletes characters from the InMemory repository.
     * @param id
     */
    public void deleteCharacter(int id) {
        characters.removeIf(character -> character.getId() == id);
    }

    // Helper method: buy

    /**
     * Helper method in order for characters to buy products.
     * @param characterID
     * @param productName
     */
    public void buyProducts(int characterID, String productName) {
        for (model.Character character : characters) {
            if (character.getId() == characterID) {
                for (Product product : products) {
                    if (Objects.equals(product.getName(), productName)) {
                        character.getProducts().add(product);
                    }
                }
            }
        }
    }

}
