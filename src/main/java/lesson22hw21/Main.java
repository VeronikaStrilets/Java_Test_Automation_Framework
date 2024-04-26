package lesson22hw21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        TodoPage todoPage = new TodoPage(driver);
        todoPage.open();

        todoPage.addNewTodo("New task");

        TodoItem todoItem = todoPage.getTodoItem("New task");
        todoItem.markAsCompleted();

        if (todoItem.isCompleted()) {
            System.out.println("Todo item marked as completed successfully.");
        } else {
            System.out.println("Failed to mark todo item as completed.");
        }

        todoPage.clearCompletedTasks();

        driver.quit();
    }
}
