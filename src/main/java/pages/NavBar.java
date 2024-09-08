package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NavBar extends Base {

    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Locators for navigation bar links
    private final By aboutPageLinkLocator = By.cssSelector("div[id=\"nav-content\"] a[href=\"https://stg.wakeb.tech/about-us\"]");
    private final By solutionsPageLinkLocator = By.cssSelector("div[id=\"nav-content\"] a[href=\"https://stg.wakeb.tech/solutions-and-services\"]");
    private final By useCasePageLinkLocator = By.cssSelector("div[id=\"nav-content\"] a[href=\"https://stg.wakeb.tech/use-cases\"]");
    private final By blogPageLinkLocator = By.cssSelector("div[id=\"nav-content\"] a[href=\"https://stg.wakeb.tech/blogs\"]");
    private final By careerPageLinkLocator = By.cssSelector("div[id=\"nav-content\"] a[href=\"https://stg.wakeb.tech/careers\"]");
    private final By contactUsPageLinkLocator = By.cssSelector("div[id=\"nav-content\"] a[href=\"https://stg.wakeb.tech/contact\"]");
    private final By applyNowPageLinkLocator = By.cssSelector("button[class=\"btn btn-solid-main navbar-button\"]");

    public NavBar(WebDriver driver) {
        super(driver);
    }

    // Method to navigate to the About page
    public void navigateToAboutPage() {
        click(aboutPageLinkLocator);
        waitForLoaderToDisappear();
    }

    // Method to navigate to the Solutions page
    public void navigateToSolutionsPage() {
        click(solutionsPageLinkLocator);
        waitForLoaderToDisappear();
    }

    // Method to navigate to the Use Case page
    public void navigateToUseCasePage() {
        click(useCasePageLinkLocator);
        waitForLoaderToDisappear();
    }

    // Method to navigate to the Blog page
    public void navigateToBlogPage() {
        click(blogPageLinkLocator);
        waitForLoaderToDisappear();
    }

    // Method to navigate to the Careers page
    public void navigateToCareerPage() {
        click(careerPageLinkLocator);
        waitForLoaderToDisappear();
    }

    // Method to navigate to the Contact Us page
    public void navigateToContactUsPage() {
        click(contactUsPageLinkLocator);
        waitForLoaderToDisappear();
    }

    // Method to navigate to the Apply Now page
    public void navigateToApplyNowPage() {
        click(careerPageLinkLocator);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(applyNowPageLinkLocator));
        waitForLoaderToDisappear();
    }

    // Helper method to scroll to a specific position on the page
    private void scrollToPosition(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(arguments[0], arguments[1]);", x, y);
    }

    // Helper method to wait until the loader disappears
    private void waitForLoaderToDisappear() {
        By loaderLocator = By.cssSelector("img[class=\" loader-logo loader-logo-gif\"]");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));
    }

    private void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
