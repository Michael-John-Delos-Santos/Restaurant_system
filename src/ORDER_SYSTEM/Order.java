package ORDER_SYSTEM;

public class Order {
    private MenuItem item;
    private int quantity;

    public Order(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    // Update getTotalAmount to handle double
    public double getTotalAmount() {
        return item.getPrice() * quantity; // Assuming item.getPrice() returns a double
    }

    public void displaySummary() {
        System.out.println("Order Summary:");
        System.out.println("Item: " + item.getName());
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + String.format("%.2f", getTotalAmount()) + " PHP");
    }
}
