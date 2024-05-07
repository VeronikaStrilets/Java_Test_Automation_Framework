package lesson31hw28;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    @BeforeMethod
    public void setup() {
        Configuration.baseUrl = "https://www.saucedemo.com";
        open("/");
        login("standard_user", "secret_sauce");
    }

    public void login(String username, String password) {
        $("#user-name").setValue(username);
        $("#password").setValue(password);
        $("#login-button").click();
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
