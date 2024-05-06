package lesson30hw27;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;

public class FillFormWithSelenide {
    public static void main(String[] args) {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.reportsFolder = "/Users/Nika/IdeaProjects/Java_Test_Automation_Framework/target/selenideReports";
        Configuration.screenshots = true;
        Configuration.savePageSource = false;

        open("/automation-practice-form");

        SelenideFormPage practiceFormPage = new SelenideFormPage();
        practiceFormPage.fillForm();
    }
}
