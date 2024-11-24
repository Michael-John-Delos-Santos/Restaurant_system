package ADMIN;

import MENU_DATA_HANDLING.MenuData;

public class DisplayCategory {

    public void displayUpdatedCategory(int categoryChoice) {
        switch (categoryChoice) {
            case 1 -> displayCategory("Chicken and Platters", MenuData.chickenAndPlattersItemNames, MenuData.chickenAndPlattersItemPrices);
            case 2 -> displayCategory("Breakfast", MenuData.breakfastItemNames, MenuData.breakfastItemPrices);
            case 3 -> displayCategory("Burger", MenuData.burgerItemNames, MenuData.burgerItemPrices);
            case 4 -> displayCategory("Drinks and Desserts", MenuData.drinksAndDessertsItemNames, MenuData.drinksAndDessertsItemPrices);
            case 5 -> displayCategory("Coffee", MenuData.coffeeItemNames, MenuData.coffeeItemPrices);
            case 6 -> displayCategory("Fries", MenuData.friesItemNames, MenuData.friesItemPrices);
            default -> System.out.println("Invalid category choice for display.");
        }
    }

    public void displayCategory(String categoryName, String[] itemNames, int[] itemPrices) {
        System.out.println("\n--- " + categoryName + " ---");
        for (int i = 0; i < itemNames.length; i++) {
            if (itemNames[i] != null) {
                System.out.println((i + 1) + ". " + itemNames[i] + " - " + itemPrices[i] + " PHP");
            }
        }
    }
}
