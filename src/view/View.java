package view;

import model.Product;
import controller.*;

import java.util.Scanner;

public class View {

    private final Controller controller = new Controller();
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        while (true) {

            // First object
            System.out.println("1. Add Product");
            System.out.println("2. Show All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");


            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> showAllProducts();
                case 3 -> updateProduct();
                case 4 -> deleteProduct();
            }
        }
    }

    // CRUD Product

    /**
     * Creates product to the InMemory repository.
     */
    private void addProduct() {
        System.out.println("Enter the product name");
        String name = scanner.nextLine();
        System.out.println("Enter the product price");
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the product region");
        String region = scanner.nextLine();
        controller.addProduct(new Product(name, price, region));
    }

    /**
     * Gets all products from the InMemory repository.
     */
    private void showAllProducts() {
        controller.getProducts().forEach(System.out::println);
    }

    /**
     * Updates products to the InMemory repository.
     */
    private void updateProduct() {
        showAllProducts();
        System.out.println("Enter the product name");
        String name = scanner.nextLine();
        System.out.println("Enter the new product name");
        String newName = scanner.nextLine();
        System.out.println("Enter the new product price");
        int newPrice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the new product universe");
        String newUniverse = scanner.nextLine();
        controller.updateProduct(name, newName, newPrice, newUniverse);
    }

    /**
     * Deletes products from the InMemory repository.
     */
    private void deleteProduct() {
        System.out.println("Enter the product name");
        String name = scanner.nextLine();
        controller.deleteProduct(name);
    }
}