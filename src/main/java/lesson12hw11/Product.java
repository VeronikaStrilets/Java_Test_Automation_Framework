package lesson12hw11;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private static int totalQuantity = 0;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        totalQuantity += quantity;
    }

    public static int getTotalQuantity() {
        return totalQuantity;
    }

    public String setName() {
        return name;
    }

    public double setPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

}
