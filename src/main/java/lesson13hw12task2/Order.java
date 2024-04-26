package lesson13hw12task2;

public class Order {
    private int orderId;
    private String customerName;

    public Order(int orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
