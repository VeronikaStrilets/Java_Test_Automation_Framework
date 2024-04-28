package lesson27hw25;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.reset;

import io.restassured.http.ContentType;

public class StoreApiTests {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    @AfterClass
    public void tearDown() {
        reset();
        System.out.println("Tests completed.");
    }

    @Test
    public void testPlaceOrder() {
        String requestBody = "{\"id\": 1, \"petId\": 1, \"quantity\": 1, \"shipDate\": \"2024-04-28T13:48:20.551Z\", \"status\": \"placed\", \"complete\": true}";

        Store store = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(BASE_URL + "/store/order")
                .then()
                .statusCode(200)
                .extract()
                .as(Store.class);

        System.out.println("Order: " + store);
    }

    @Test(dependsOnMethods = {"testPlaceOrder"})
    public void testGetOrderById() {
        int orderId = 1;

        Store store = given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URL + "/store/order/{orderId}", orderId)
                .then()
                .statusCode(200)
                .extract()
                .as(Store.class);

        System.out.println("Order by id " + orderId + ": " + store);
    }

    @Test
    public void testGetStoreInventory() {
        StoreInventoryResponse storeInventoryResponse = given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URL + "/store/inventory")
                .then()
                .statusCode(200)
                .extract()
                .as(StoreInventoryResponse.class);

        System.out.println("Inventory: " + storeInventoryResponse);
    }
}
