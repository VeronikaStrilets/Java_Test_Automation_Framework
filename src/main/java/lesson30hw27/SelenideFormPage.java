package lesson30hw27;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class SelenideFormPage {

    private SelenideElement firstNameField = $("#firstName");
    private SelenideElement lastNameField = $("#lastName");
    private SelenideElement userEmailField = $("#userEmail");
    private SelenideElement radioButtonMale = $(byXpath("//label[@for='gender-radio-1']"));
    private SelenideElement radioButtonFemale = $(byXpath("//label[@for='gender-radio-2']"));
    private SelenideElement radioButtonOther = $(byXpath("//label[@for='gender-radio-3']"));
    private SelenideElement userMobileNumberField = $("#userNumber");
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesCheckboxReading = $(byXpath("//label[contains(., 'Reading')]/preceding-sibling::input[@type='checkbox']"));
    private SelenideElement currentAddressField = $("#currentAddress");
    private SelenideElement uploadPictureButton = $("#uploadPicture");
    private SelenideElement stateDropdown = $("#react-select-3-input");
    private SelenideElement cityDropdown = $("#react-select-4-input");
    private SelenideElement submitButton = $("#submit");

    public void fillForm() {
        scrollAndSet(firstNameField, "Veronika");
        scrollAndSet(lastNameField, "Strilets");
        scrollAndSet(userEmailField, "veronika.strilets@gmail.com");
        safeClick(radioButtonFemale);
        scrollAndSet(userMobileNumberField, "1234567890");
        setDate("08", "June", "1991");
        scrollAndSet(subjectsInput, "Maths");
        subjectsInput.pressEnter();
        safeClick(hobbiesCheckboxReading);
        scrollAndSet(currentAddressField, "123 Main St, City, Country");
        scrollAndUpload(uploadPictureButton, "test.png");
        scrollAndSetValue(stateDropdown, "NCR");
        stateDropdown.pressEnter();
        scrollAndSetValue(cityDropdown, "Delhi");
        cityDropdown.pressEnter();
        safeClick(submitButton);

        try {
            $("div.modal-title.h4#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            System.out.println("The form is successfully submitted.");
        } catch (Exception e) {
            System.err.println("Fail to submit the form: " + e.getMessage());
        }

    }

    private void scrollAndSet(SelenideElement element, String value) {
        element.scrollIntoView(true);
        element.setValue(value);
    }

    private void scrollAndUpload(SelenideElement element, String filePath) {
        element.scrollIntoView(true);
        element.uploadFromClasspath(filePath);
    }

    private void scrollAndSetValue(SelenideElement element, String value) {
        element.scrollIntoView(true);
        element.setValue(value);
    }

    private void setDate(String day, String month, String year) {
        dateOfBirthInput.scrollIntoView(true);
        dateOfBirthInput.click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        String daySelector = String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day);
        $(daySelector).click();
    }

    private void safeClick(SelenideElement element) {
        element.scrollIntoView(true);
        executeJavaScript("arguments[0].click();", element);
    }
}
