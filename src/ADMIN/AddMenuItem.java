package ADMIN;

import MENU_DATA_HANDLING.MenuData;
import java.util.Scanner;
import java.util.Arrays;

public class AddMenuItem {
    Scanner scanner = new Scanner(System.in);
    DisplayCategory displayCategoryObj = new DisplayCategory(); 

    public void AddMenu() {
        System.out.println("Select the category to add an item:");
        System.out.println("1. Chicken and Platters");
        System.out.println("2. Breakfast");
        System.out.println("3. Burgers");
        System.out.println("4. Drinks and Desserts");
        System.out.println("5. Coffee");
        System.out.println("6. Fries");
        System.out.print("Enter your choice (1-6): ");
        int categoryChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (categoryChoice < 1 || categoryChoice > 6) {
            System.out.println("Invalid category choice. Returning to menu.");
            return;
        }

        System.out.print("Enter the item name: ");
        String itemName = scanner.nextLine();

        System.out.print("Enter the item price: ");
        int itemPrice = getValidatedPrice();

        // Add the new item to the selected category
        switch (categoryChoice) {
            case 1 -> addToCategory(MenuData.chickenAndPlattersItemNames, MenuData.chickenAndPlattersItemPrices, itemName, itemPrice, "Chicken and Platters");
            case 2 -> addToCategory(MenuData.breakfastItemNames, MenuData.breakfastItemPrices, itemName, itemPrice, "Breakfast");
            case 3 -> addToCategory(MenuData.burgerItemNames, MenuData.burgerItemPrices, itemName, itemPrice, "Burgers");
            case 4 -> addToCategory(MenuData.drinksAndDessertsItemNames, MenuData.drinksAndDessertsItemPrices, itemName, itemPrice, "Drinks and Desserts");
            case 5 -> addToCategory(MenuData.coffeeItemNames, MenuData.coffeeItemPrices, itemName, itemPrice, "Coffee");
            case 6 -> addToCategory(MenuData.friesItemNames, MenuData.friesItemPrices, itemName, itemPrice, "Fries");
            default -> System.out.println("Unknown category.");
        }

        System.out.println("Item added successfully.\n");

        // Display the updated category items
        displayCategoryObj.displayUpdatedCategory(categoryChoice);

        waitForEnter();
    }

    private void addToCategory(String[] itemNames, int[] itemPrices, String newItemName, int newItemPrice, String category) {
        int currentSize = itemNames.length;

        // Extend the arrays to include the new item
        String[] newItemNames = Arrays.copyOf(itemNames, currentSize + 1);
        int[] newItemPrices = Arrays.copyOf(itemPrices, currentSize + 1);

        // Add new item to the end of the arrays
        newItemNames[currentSize] = newItemName;
        newItemPrices[currentSize] = newItemPrice;

        // Update the MenuData arrays directly based on category
        switch (category) {
            case "Chicken and Platters" -> {
                MenuData.chickenAndPlattersItemNames = newItemNames;
                MenuData.chickenAndPlattersItemPrices = newItemPrices;
                MenuData.NUM_CHICKENANDPLATTERS_ITEMS++;
            }
            case "Breakfast" -> {
                MenuData.breakfastItemNames = newItemNames;
                MenuData.breakfastItemPrices = newItemPrices;
                MenuData.NUM_BREAKFAST_ITEMS++;
            }
            case "Burgers" -> {
                MenuData.burgerItemNames = newItemNames;
                MenuData.burgerItemPrices = newItemPrices;
                MenuData.NUM_BURGER_ITEMS++;
            }
            case "Drinks and Desserts" -> {
                MenuData.drinksAndDessertsItemNames = newItemNames;
                MenuData.drinksAndDessertsItemPrices = newItemPrices;
                MenuData.NUM_DRINKS_AND_DESSERTS_ITEMS++;
            }
            case "Coffee" -> {
                MenuData.coffeeItemNames = newItemNames;
                MenuData.coffeeItemPrices = newItemPrices;
                MenuData.NUM_COFFEE_ITEMS++;
            }
            case "Fries" -> {
                MenuData.friesItemNames = newItemNames;
                MenuData.friesItemPrices = newItemPrices;
                MenuData.NUM_FRIES_ITEMS++;
            }
            default -> System.out.println("Unknown category.");
        }
    }

    private int getValidatedPrice() {
        int price;
        while (true) {
            try {
                price = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (price < 0) throw new IllegalArgumentException("Price must be non-negative.");
                return price;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid price:");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    public void waitForEnter() {
        System.out.print("Press Enter to continue...");
        scanner.nextLine();
    }
}
