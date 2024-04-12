package lesson22hw21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TodoPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public TodoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void open() {
        driver.get("https://voloshchukstanislav.pythonanywhere.com/");
    }

    public void addNewTodo(String todoText) {
        WebElement newTodoInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_text")));
        newTodoInput.sendKeys(todoText);
        newTodoInput.submit();
    }

    public TodoItem getTodoItem(String todoText) {
        By todoItemLocator = By.xpath("//li[contains(text(), '" + todoText + "')]");
        WebElement todoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(todoItemLocator));
        return new TodoItem(todoElement, wait, todoItemLocator);
    }

    public void clearCompletedTasks() {
        WebElement clearButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(., 'DELETE COMPLETED')]")));
        clearButton.click();
    }

}
