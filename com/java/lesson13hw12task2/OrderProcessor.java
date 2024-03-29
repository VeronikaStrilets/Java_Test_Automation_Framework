package lesson13hw12task2;

import java.util.LinkedList;
import java.util.Queue;

public class OrderProcessor {
    Queue<Order> orderQueue = new LinkedList<>();

    // Add a new order
    public void addOrder(Order order) {
        orderQueue.offer(order);
        System.out.println("New order added to the queue.");
    }

    // Process a next order (delete from a queue)
    public void processNextOrder() {
        if (!orderQueue.isEmpty()) {
            Order nextOrder = orderQueue.poll();
            System.out.println("Processing order: " + nextOrder);
        } else {
            System.out.println("No orders to process. The queue is empty.");
        }
    }

    // Display all orders
    public void displayAllOrders() {
        if (!orderQueue.isEmpty()) {
            System.out.println("Orders in the queue:");
            for (Order order : orderQueue) {
                System.out.println(order);
            }
        } else {
            System.out.println("The queue is empty. No orders to display.");
        }
    }

    // Check if queue is empty
    public boolean isQueueEmpty() {
        return orderQueue.isEmpty();
    }
}
