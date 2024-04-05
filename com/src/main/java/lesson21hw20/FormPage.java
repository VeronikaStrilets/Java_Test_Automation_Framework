package lesson21hw20;

import org.openqa.selenium.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FormPage {
    private WebDriver driver;

    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("userEmail");
    private By radioButtonMale = By.xpath("//label[@for='gender-radio-1']");
    private By radioButtonFemale = By.xpath("//label[@for='gender-radio-2']");
    private By radioButtonOther = By.xpath("//label[@for='gender-radio-3']");
    private By mobileNumberField = By.id("userNumber");
    private By dateOfBirthInput = By.id("dateOfBirthInput");
    private By yearDropdown = By.className("react-datepicker__year-select");
    private By monthDropdown = By.className("react-datepicker__month-select");
    private By subjectsInput = By.id("subjectsInput");
    private By currentAddressField = By.id("currentAddress");
    private By pictureUploadButton = By.id("uploadPicture");
    private By stateDropdown = By.id("react-select-3-input");
    private By cityDropdown = By.id("react-select-4-input");
    private By submitButton = By.id("submit");

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void selectRadioButtonMale() {
        driver.findElement(radioButtonMale).click();
    }

    public void selectRadioButtonFemale() {
        driver.findElement(radioButtonFemale).click();
    }

    public void selectRadioButtonOther() {
        driver.findElement(radioButtonOther).click();
    }

    public void enterMobileNumber(String mobileNumber) {
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
    }

    public void selectDate(String year, String month, String day) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        driver.findElement(dateOfBirthInput).click();
        Select selectYear = new Select(driver.findElement(yearDropdown));
        selectYear.selectByValue(year);

        Select selectMonth = new Select(driver.findElement(monthDropdown));
        selectMonth.selectByValue(month);

        By dayToSelect = By.xpath("//div[contains(@class, 'react-datepicker__day--0"+ day + "') and not(contains(@class, 'react-datepicker__day--outside'))]");
        WebElement dayElement = driver.findElement(dayToSelect);

        Actions actions = new Actions(driver);
        actions.moveToElement(dayElement).click().perform();
    }

    public void enterSubjects(String subject) {
        driver.findElement(subjectsInput).sendKeys(subject);
        driver.findElement(subjectsInput).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(subjectsInput).sendKeys(Keys.ENTER);
    }

    public void selectHobbies(String hobby) {
        String xpathExpression = "//label[contains(., '" + hobby + "')]/preceding-sibling::input[@type='checkbox']";
        WebElement checkbox = driver.findElement(By.xpath(xpathExpression));

        Actions actions = new Actions(driver);
        actions.moveToElement(checkbox).click().perform();
    }

    public void enterCurrentAddress(String address) {
        driver.findElement(currentAddressField).sendKeys(address);
    }

    public void uploadPicture(String picturePath) {
        driver.findElement(pictureUploadButton).sendKeys(picturePath);
    }

    public void selectState(String state) {
        WebElement stateElement = driver.findElement(stateDropdown);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stateElement);

        stateElement.sendKeys(state);
        stateElement.sendKeys(Keys.ARROW_DOWN);
        stateElement.sendKeys(Keys.ENTER);
    }

    public void selectCity(String city) {
        driver.findElement(cityDropdown).sendKeys(city);
        driver.findElement(cityDropdown).sendKeys(Keys.ENTER);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

}
