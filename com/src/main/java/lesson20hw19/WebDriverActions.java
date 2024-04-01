package lesson20hw19;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WebDriverActions {

    public void performEventChain(WebDriver driver) {

        Actions actions = new Actions(driver);

        // Find and click on coursesMenu button
        WebElement coursesMenu = driver.findElement(By.xpath("//button[@data-dropdown-trigger='coursesMenu']"));
        actions.click(coursesMenu).perform();

        // Find inputSearch field and type search string there
        WebElement inputSearch = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='coursesMenuSearchField']/input")));

        String searchString = "java automation";
        actions.sendKeys(inputSearch, searchString).perform();

        // Find javaAutomationCourse link and click on it
        WebElement javaAutomationCourse = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='coursesMenuSearchPanel']//ul[@class='course-list']/li/a[@href='https://ithillel.ua/courses/qa-automation']")));

        if (javaAutomationCourse != null) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", javaAutomationCourse);
        } else {
            System.out.println("Element 'javaAutomationCourse' not found!");
        }

        // Find siteHeaderLogo element and click on it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement siteHeaderLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("site-header-logo")));

        // Get current window handles count
        Set<String> windowHandlesBefore = driver.getWindowHandles();

        // Open new tab with siteHeaderLogo href
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", siteHeaderLogo.getAttribute("href"));

        // Wait for the new window to be opened
        wait.until(ExpectedConditions.numberOfWindowsToBe(windowHandlesBefore.size() + 1));

        // Find employment link and open it in a new tab
        WebElement siteNavItem = driver.findElement(By.xpath("//li[@class='site-nav-list_item -employment']//a"));

        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", siteNavItem.getAttribute("href"));

        // Get window handles after opening new tabs
        Set<String> windowHandles = driver.getWindowHandles();

        List<String> windowHandlesList = new ArrayList<>(windowHandles);

        // Check if that 3 windows are opened
        if (windowHandles.size() >= 3) {
            driver.switchTo().window(windowHandlesList.get(2));
            System.out.println("We have opened the 3rd window");
            String title = driver.getTitle();
            System.out.println("Title of the 3rd window: " + title);
        } else {
            System.out.println("We don't have the 3rd window");
        }
    }
}
