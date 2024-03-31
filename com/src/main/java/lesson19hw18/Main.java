package lesson19hw18;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Main {
    public static void main(String[] args) {

        String baseUrl = "https://ithillel.ua";

        WebDriver driver = new SafariDriver();

        driver.get(baseUrl);

    }
}
