package lesson22hw21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TodoItem {
    private WebElement todoElement;
    private WebDriverWait wait;
    private By locator;

    public TodoItem(WebElement todoElement, WebDriverWait wait, By locator) {
        this.todoElement = todoElement;
        this.wait = wait;
        this.locator = locator;
    }

    public void markAsCompleted() {
        todoElement.click();
        reLocateElement();
    }

    public boolean isCompleted() {
        String classAttributeValue = todoElement.getAttribute("class");
        return classAttributeValue.contains("completed");
    }

    private void reLocateElement() {
        todoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
