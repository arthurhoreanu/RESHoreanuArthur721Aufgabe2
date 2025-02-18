package controller;

import model.*;
import model.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Controller {

    List<Product> produkte = new ArrayList<>();
    List<Character> charaktere = new ArrayList<>();

    public void initialize() {
        produkte.add(new Product("Mjolnir", 500.0, "Asgard"));
        produkte.add(new Product("Vibranium-Schild", 700.0, "Wakanda"));
        produkte.add(new Product("Infinity Gauntlet", 10000.0, "Titan"));
        produkte.add(new Product("Web-Shooter", 250.0, "Terra"));
        produkte.add(new Product("Arc-Reaktor", 1500.0, "Terra"));
        produkte.add(new Product("Norn Stones", 1200.0, "Asgard"));
        produkte.add(new Product("Quantum Suit", 3000.0, "Terra"));
        produkte.add(new Product("X-Gene Serum", 850.0, "X-Mansion"));
        produkte.add(new Product("Cosmic Cube", 9000.0, "Multiverse"));
        produkte.add(new Product("Darkhold", 2000.0, "Multiverse"));

        Character c1 = new Character(1, "Thor", "Asgard");
        kaufeProdukt(c1.getId(), "Mjolnir"); // Mjolnir
        kaufeProdukt(c1.getId(), "Norn Stones"); // Norn Stones
        kaufeProdukt(c1.getId(), "Darkhold"); // Darkhold

        Character c2 = new Character(2, "Black Panther", "Wakanda");
        kaufeProdukt(c2.getId(), "Vibranium-Schild"); // Vibranium-Schild
        kaufeProdukt(c2.getId(), "X-Gene Serum"); // X-Gene Serum

        Character c3 = new Character(3, "Iron Man", "Terra");
        kaufeProdukt(c3.getId(), "Arc-Reaktor"); // Arc-Reaktor
        kaufeProdukt(c3.getId(), "Quantum Suit"); // Quantum Suit
        kaufeProdukt(c3.getId(), "Web-Shooter"); // Web-Shooter

        Character c4 = new Character(4, "Spider-Man", "Terra");
        kaufeProdukt(c4.getId(), " Web-Shooter"); // Web-Shooter
        kaufeProdukt(c4.getId(), "Cosmic Cube"); // Cosmic Cube

        Character c5 = new Character(5, "Doctor Strange", "Multiverse");
        kaufeProdukt(c5.getId(),"Darkhold"); // Darkhold
        kaufeProdukt(c5.getId(), "Cosmic Cube"); // Cosmic Cube
        kaufeProdukt(c5.getId(), "Infinity Gauntlet"); // Infinity Gauntlet

        charaktere.add(c1);
        charaktere.add(c2);
        charaktere.add(c3);
        charaktere.add(c4);
        charaktere.add(c5);
    }

    // CRUD Product

    /**
     * Adds product to the InMemory repository.
     * @param product
     */
    public void addProduct(Product product) {
        produkte.add(product);
    }

    /**
     * Gets all products from the InMemory repository.
     * @return
     */
    public List<Product> getProducts() {
        return produkte;
    }

    /**
     * Updates products from the InMemory repository.
     * @param newName
     * @param newPrice
     * @param newUniverse
     */
    public void updateProduct(String inputName, String newName, int newPrice, String newUniverse) {
        for (Product product : produkte) {
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
        produkte.removeIf(product -> Objects.equals(product.getName(), name));
    }

    // CRUD Character

    /**
     * Adds character to the InMemory repository.
     * @param character
     */
    public void addCharacter(model.Character character) {
        for( Character characterFromList : charaktere) {
            if(characterFromList.getId() == character.getId()) {
                throw new IllegalArgumentException("Character already exists");
            }
        }
        charaktere.add(character);
    }

    /**
     * Gets all characters from the InMemory repository.
     * @return
     */
    public List<model.Character> getCharacterList() {
        return charaktere;
    }

    /**
     * Updates characters from the InMemory repository.
     * @param id
     * @param newName
     * @param newRegion
     */
    public void updateCharacter(int id, String newName, String newRegion) {
        for (model.Character character : charaktere) {
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
        charaktere.removeIf(character -> character.getId() == id);
    }

    // Helper method: buy
    public void kaufeProdukt(int characterID, String productName) {
        for (model.Character character : charaktere) {
            if (character.getId() == characterID) {
                for (Product product : produkte) {
                    if (Objects.equals(product.getName(), productName)) {
                        character.getProducts().add(product);
                    }
                }
            }
        }
    }

    public List<model.Character> filterCharactersByUniverse(String universe) {
        List<model.Character> filteredList = new ArrayList<>();
        for (model.Character character : charaktere) {
            if (character.getRegion().equals(universe)) {
                filteredList.add(character);
            }
        }
        return filteredList;
    }

    /**
     * Filters characters that have bought products from a specific universe (user input from view).
     */
    public List<model.Character> filterCharacterByProductUniverse(String universe) {
        List<model.Character> filteredCustomers = new ArrayList<>();
        for (model.Character character : charaktere) {
            for (Product product : character.getProducts()) {
                if (product.getUniverse().equals(universe)) {
                    filteredCustomers.add(character);
                }
            }
        }
        return filteredCustomers;
    }
}