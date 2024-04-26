package lesson21hw20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FillForm {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/automation-practice-form");

        FormPage practiceFormPage = new FormPage(driver);

        practiceFormPage.enterFirstName("Veronika");
        practiceFormPage.enterLastName("Strilets");
        practiceFormPage.enterEmail("veronika.strilets@gmail.com");
        practiceFormPage.selectRadioButtonFemale();
        practiceFormPage.enterMobileNumber("1234567890");
        practiceFormPage.selectDate("1991", "1", "08");
        practiceFormPage.enterSubjects("Maths");
        practiceFormPage.selectHobbies("Reading");
        practiceFormPage.enterCurrentAddress("123 Main St, City, Country");
        practiceFormPage.uploadPicture("/Users/Nika/Desktop/MVN.png");
        practiceFormPage.selectState("NCR");
        practiceFormPage.selectCity("Delhi");
        practiceFormPage.clickSubmitButton();

        driver.close();
    }
}
