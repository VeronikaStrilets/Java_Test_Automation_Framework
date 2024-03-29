package lesson17hw16;

import lesson13hw12task2.Order;
import lesson13hw12task2.OrderProcessor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class OrderProcessorTest {

    private OrderProcessor orderProcessor;

    @BeforeMethod
    public void setUp() {
        orderProcessor = new OrderProcessor();
    }

    @AfterMethod
    public void clean() {
        orderProcessor = null;
    }

    @DataProvider(name = "orderData")
    public Object[][] orderData() {
        return new Object[][]{
                {new Order(1, "Customer1")},
                {new Order(2, "Customer2")},
                {new Order(3, "Customer3")}
        };
    }

    @DataProvider(name = "orderDataArray")
    public Object[][] orderDataArray() {
        return new Object[][]{
                {new Order[]{new Order(1, "Customer1"), new Order(2, "Customer2"), new Order(3, "Customer3")}}
        };
    }

    @Test(dataProvider = "orderData")
    public void testAddOrder(Order order) {
        orderProcessor.addOrder(order);
        assertFalse(orderProcessor.isQueueEmpty());
    }

    @Test(dataProvider = "orderData")
    public void testProcessNextOrder(Order order) {
        orderProcessor.addOrder(order);
        orderProcessor.processNextOrder();
        assertTrue(orderProcessor.isQueueEmpty());
    }

    @Test(dataProvider = "orderDataArray")
    public void testDisplayAllOrders(Order[] orders) {
        for (Order order : orders) {
            orderProcessor.addOrder(order);
        }
        assertNotNull(orderProcessor.displayAllOrders());
    }
}
