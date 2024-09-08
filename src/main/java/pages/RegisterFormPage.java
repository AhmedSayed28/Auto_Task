package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterFormPage extends Base {

    // Locators for various elements on the registration form
    private final By firstNameInputLocator = By.cssSelector("input[id=\"nf-field-17\"]");
    private final By lastNameInputLocator = By.cssSelector("input[id=\"nf-field-18\"]");
    private final By courseListLocator = By.cssSelector("select[id=\"nf-field-22\"]");
    private final By monthListLocator = By.cssSelector("select[id=\"nf-field-24\"]");
    private final By emailInputLocator = By.cssSelector("input[id=\"nf-field-19\"]");
    private final By phoneInputLocator = By.cssSelector("input[id=\"nf-field-20\"]");
    private final By linkedInLocator = By.cssSelector("label[id=\"nf-label-class-field-23-1\"]");
    private final By submitFormBtnLocator = By.cssSelector("input[id=\"nf-field-15\"]");
    private final By successMsgLocator = By.cssSelector("div[class=\"nf-response-msg\"] p");

    // Constructor initializing the WebDriver
    public RegisterFormPage(WebDriver driver) {
        super(driver);
    }

    // Method to fill out the sign-up form
    public void fillSignUpForm(String firstName, String lastName, String course, String phone, String email, String month) {
        setTextElement(driver.findElement(firstNameInputLocator), firstName);
        setTextElement(driver.findElement(lastNameInputLocator), lastName);
        setTextElement(driver.findElement(emailInputLocator), email);
        setTextElement(driver.findElement(phoneInputLocator), phone);

        selectFromDropdownByVisibleText(courseListLocator, course);
        selectFromDropdownByVisibleText(monthListLocator, month);

        driver.findElement(linkedInLocator).click();
        click(submitFormBtnLocator);
    }

    // Helper method to select from a dropdown by visible text
    private void selectFromDropdownByVisibleText(By locator, String visibleText) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(visibleText);
    }

    // Method to retrieve the success message after form submission
    public String getSuccessMsg() {
        WebElement element = waitUntilElementToBevisible(successMsgLocator);
        return element.getText();
    }
}
