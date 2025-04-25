package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SearchInventory {
    public static void main(String[] args) {
        ArrayList<Product> inventory = loadInventoryFromFile("src/main/resources/inventory.csv");
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1- List products");
            System.out.println("2- Lookup a product by its id");
            System.out.println("3- Find all products within a price range");
            System.out.println("4- Add a new product");
            System.out.println("5- Quit the application");
            System.out.print("Enter command: ");
            choice = scanner.nextInt();
            scanner.nextLine();
//choice
            switch (choice) {
                case 1 -> listProducts(inventory);
                case 2 -> lookupId(inventory, scanner);
                case 3 -> findProductsInPriceRange(inventory, scanner);
                case 4 -> NewProduct(inventory, scanner);
                case 5 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }
//load from file
    public static ArrayList<Product> loadInventoryFromFile(String filename) {
        ArrayList<Product> inventory = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                inventory.add(new Product(id, name, price));
            }
//sort by name
            inventory.sort(Comparator.comparing(Product::getName));
        } catch (IOException e) {
            System.out.println("Error reading inventory file: " + e.getMessage());
        }
        return inventory;
    }
//list products
    public static void listProducts(ArrayList<Product> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            for (Product p : inventory) {
                System.out.println(p);
            }
        }
    }
//look by id
    public static void lookupId(ArrayList<Product> inventory, Scanner scanner) {
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        for (Product p : inventory) {
            if (p.getId() == id) {
                System.out.println(p);
                return;
            }
        }
        System.out.println("no product found");
    }
//find products
    public static void findProductsInPriceRange(ArrayList<Product> inventory, Scanner scanner) {
        System.out.print("Enter minimum price: ");
        double min = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double max = scanner.nextDouble();
        boolean found = false;
        for (Product p : inventory) {
            if (p.getPrice() >= min && p.getPrice() <= max) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found.");
        }
    }
// add new
    public static void NewProduct(ArrayList<Product> inventory, Scanner scanner) {
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        inventory.add(new Product(id, name, price));


        inventory.sort(Comparator.comparing(Product::getName)); // keep it sorted
        System.out.println("Product added.");
    }
}




