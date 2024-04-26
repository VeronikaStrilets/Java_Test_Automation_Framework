package lesson20hw19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        String baseUrl = "https://ithillel.ua";

        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);

        WebDriverActions webDriverActions = new WebDriverActions();
        webDriverActions.performEventChain(driver);
    }
}
