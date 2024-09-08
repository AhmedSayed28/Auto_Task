package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage extends Base {

    // Locators for contact form elements
    private final By firstNameInputLocator = By.cssSelector("input[id=\"name\"]");
    private final By emailInputLocator = By.cssSelector("input[id=\"email\"]");
    private final By phoneInputLocator = By.cssSelector("input[id=\"phone\"]");
    private final By subjectInputLocator = By.cssSelector("input[id=\"subject\"]");
    private final By messageInputLocator = By.cssSelector("textarea[id=\"message\"]");
    private final By submitBtnLocator = By.cssSelector("button[id=\"contactFormSubmit\"]");
    private final By contactFormSuccessMsgLocator = By.cssSelector("div[class=\"alert alert-success alert-dismissible fade show mt-3\"]");

    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    // Method to fill the contact form with valid data and submit it
    public void fillContactFormWithValidData(String name, String email, String phone, String subject, String message) {
        setTextElement(driver.findElement(firstNameInputLocator), name);
        setTextElement(driver.findElement(emailInputLocator), email);
        setTextElement(driver.findElement(phoneInputLocator), phone);
        setTextElement(driver.findElement(subjectInputLocator), subject);
        setTextElement(driver.findElement(messageInputLocator), message);
        click(submitBtnLocator);
    }

    // Method to check if the success message is displayed after form submission
    public boolean isSuccess() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactFormSuccessMsgLocator));
        return driver.findElement(contactFormSuccessMsgLocator).isDisplayed();
    }
}
