package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage extends Base {

    // Locators for various elements on the home page
    public final By loaderLocator = By.cssSelector("img[class=\" loader-logo loader-logo-gif\"]");
    private final By localizationLocator = By.cssSelector("ul[class=\"d-flex gap-3 align-items-center mb-0 p-0\"] a[title=\"language\"] span");
    private final By aboutSectionLocator = By.cssSelector("section[id=\"about\"]");
    private final By subsNewsletterEmailInputLocator = By.cssSelector("input[id=\"subscribe_email\"]");
    private final By subsNewsletterBtnLocator = By.cssSelector("button[id=\"basic-addon1\"]");
    private final By subsNewsletterSuccessMsgLocator = By.cssSelector("p[id=\"subscribed_success\"]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Method to check if loader exists on the page
    public boolean isLoaderExist() {
        try {
            WebElement loader = driver.findElement(loaderLocator);
            return loader.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Method to switch the website language
    public void switchLanguage() {
        click(localizationLocator);
    }

    // Method to verify if the About section is present and visible
    public boolean isWebsiteSectionsExist() {
        try {
            WebElement aboutSec = driver.findElement(aboutSectionLocator);
            scrollToElement(aboutSec);
            return aboutSec.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Helper method to scroll to a specific element
    private void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Method to subscribe to the newsletter with a provided email
    public void subscribeNewsletter(String email) {
        setTextElement(driver.findElement(subsNewsletterEmailInputLocator), email);
        click(subsNewsletterBtnLocator);
    }

    // Method to get the subscription success message
    public String getSubscribeNewsletterSuccessMsg() {
        return waitUntilElementToBeVisible(subsNewsletterSuccessMsgLocator).getText();
    }

    // Method to wait until an element is visible
    private WebElement waitUntilElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
