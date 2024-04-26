package lesson13hw12task2;

public class Main {

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        Order order1 = new Order(1, "Customer1");
        Order order2 = new Order(2, "Customer2");
        Order order3 = new Order(3, "Customer3");

        orderProcessor.addOrder(order1);
        orderProcessor.addOrder(order2);
        orderProcessor.addOrder(order3);

        orderProcessor.displayAllOrders();

        System.out.println("Is the queue empty? " + orderProcessor.isQueueEmpty());

        orderProcessor.processNextOrder();

        orderProcessor.displayAllOrders();
    }
}
