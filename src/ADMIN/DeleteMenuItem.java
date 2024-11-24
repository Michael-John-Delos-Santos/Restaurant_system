package ADMIN;

import MENU_DATA_HANDLING.MenuData;
import java.util.Scanner;

public class DeleteMenuItem {
    Scanner scanner = new Scanner(System.in);
    DisplayCategory displayCategoryObj = new DisplayCategory(); // Create an instance of DisplayCategory

    public void DeleteMenu() {
        int choice = -1; // Initial invalid value to enter the loop

        while (choice != 0) {
            // Display category options
            System.out.println("Select Category to Delete Item:");
            System.out.println("1. Chicken and Platters");
            System.out.println("2. Breakfast");
            System.out.println("3. Burger");
            System.out.println("4. Drinks and Desserts");
            System.out.println("5. Coffee");
            System.out.println("6. Fries");
            System.out.println("0 to Return.");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 0) {
                return; // Exit the method if user chooses to return
            }

            // Display the items based on the selected category
            switch (choice) {
                case 1 -> deleteFromCategory("Chicken and Platters", MenuData.chickenAndPlattersItemNames, MenuData.chickenAndPlattersItemPrices, choice);
                case 2 -> deleteFromCategory("Breakfast", MenuData.breakfastItemNames, MenuData.breakfastItemPrices, choice);
                case 3 -> deleteFromCategory("Burger", MenuData.burgerItemNames, MenuData.burgerItemPrices, choice);
                case 4 -> deleteFromCategory("Drinks and Desserts", MenuData.drinksAndDessertsItemNames, MenuData.drinksAndDessertsItemPrices, choice);
                case 5 -> deleteFromCategory("Coffee", MenuData.coffeeItemNames, MenuData.coffeeItemPrices, choice);
                case 6 -> deleteFromCategory("Fries", MenuData.friesItemNames, MenuData.friesItemPrices, choice);
                default -> System.out.println("Invalid choice! Please select a valid category.");
            }
        }
    }

    private void deleteFromCategory(String categoryName, String[] itemNames, int[] itemPrices, int categoryChoice) {
        System.out.println("\n--- " + categoryName + " ---");
        int numItems = getNumItems(categoryName); // Get current number of items in the category
        if (numItems == 0) {
            System.out.println("No items in this category.");
            return;
        }

        // Display current items in the selected category
        for (int i = 0; i < numItems; i++) {
            System.out.println((i + 1) + ". " + itemNames[i] + " - " + itemPrices[i] + " PHP");
        }

        System.out.print("Enter item number to delete: ");
        int itemToDelete = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (itemToDelete < 1 || itemToDelete > numItems) {
            System.out.println("Invalid item number.");
            return;
        }

        // Create new arrays with reduced size
        String[] newItemNames = new String[numItems - 1];
        int[] newItemPrices = new int[numItems - 1];

        // Copy elements excluding the deleted one
        for (int i = 0, j = 0; i < numItems; i++) {
            if (i != itemToDelete - 1) {
                newItemNames[j] = itemNames[i];
                newItemPrices[j] = itemPrices[i];
                j++;
            }
        }

        // Update MenuData arrays
        switch (categoryName) {
            case "Chicken and Platters":
                MenuData.chickenAndPlattersItemNames = newItemNames;
                MenuData.chickenAndPlattersItemPrices = newItemPrices;
                break;
            case "Breakfast":
                MenuData.breakfastItemNames = newItemNames;
                MenuData.breakfastItemPrices = newItemPrices;
                break;
            case "Burger":
                MenuData.burgerItemNames = newItemNames;
                MenuData.burgerItemPrices = newItemPrices;
                break;
            case "Drinks and Desserts":
                MenuData.drinksAndDessertsItemNames = newItemNames;
                MenuData.drinksAndDessertsItemPrices = newItemPrices;
                break;
            case "Coffee":
                MenuData.coffeeItemNames = newItemNames;
                MenuData.coffeeItemPrices = newItemPrices;
                break;
            case "Fries":
                MenuData.friesItemNames = newItemNames;
                MenuData.friesItemPrices = newItemPrices;
                break;
        }

        // Update item count
        setNumItems(categoryName, numItems - 1);

        System.out.println("Item deleted successfully.");
        displayCategoryObj.displayUpdatedCategory(categoryChoice);
    }

    private int getNumItems(String categoryName) {
        switch (categoryName) {
            case "Chicken and Platters": return MenuData.NUM_CHICKENANDPLATTERS_ITEMS;
            case "Breakfast": return MenuData.NUM_BREAKFAST_ITEMS;
            case "Burger": return MenuData.NUM_BURGER_ITEMS;
            case "Drinks and Desserts": return MenuData.NUM_DRINKS_AND_DESSERTS_ITEMS;
            case "Coffee": return MenuData.NUM_COFFEE_ITEMS;
            case "Fries": return MenuData.NUM_FRIES_ITEMS;
            default: return 0;
        }
    }

    private void setNumItems(String categoryName, int numItems) {
        switch (categoryName) {
            case "Chicken and Platters": MenuData.NUM_CHICKENANDPLATTERS_ITEMS = numItems; break;
            case "Breakfast": MenuData.NUM_BREAKFAST_ITEMS = numItems; break;
            case "Burger": MenuData.NUM_BURGER_ITEMS = numItems; break;
            case "Drinks and Desserts": MenuData.NUM_DRINKS_AND_DESSERTS_ITEMS = numItems; break;
            case "Coffee": MenuData.NUM_COFFEE_ITEMS = numItems; break;
            case "Fries": MenuData.NUM_FRIES_ITEMS = numItems; break;
            default: System.out.println("Invalid category name for setNumItems.");
        }
    }
}
