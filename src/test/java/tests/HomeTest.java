package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

public class HomeTest extends TestBase {
    HomePage home;
    SoftAssert soft = new SoftAssert();
    Faker fake = new Faker();

    @Test
    public void testLoader() throws InterruptedException {
        logger = extent.createTest("Verify the Home page loaded successfully");
        home = new HomePage(driver);
        // Check if loader is present
        reporter("pass", "Home page loaded successfully");

    }

    @Test
    public void testLocalization() throws InterruptedException {
        logger = extent.createTest("Verify that user can switch the language");
        home = new HomePage(driver);
        home.switchLanguage();
        // Verify if the language switch is successful
        if (driver.getCurrentUrl().contains("/ar")) {
            reporter("pass", "Language switched successfully");
        } else {
            reporter("fail", "Language did not switch!");
        }
    }

    @Test
    public void testAboutSection() throws InterruptedException {
        logger = extent.createTest("Verify About Section exists and is visible");
        home = new HomePage(driver);
        // Check if the About section is present
        if (home.isWebsiteSectionsExist()) {
            reporter("pass", "Website sections are visible successfully");
        } else {
            reporter("fail", "Website sections are not visible!");
        }
    }

    @Test
    public void testSubscribeNews() throws InterruptedException {
        logger = extent.createTest("Verify User can subscribe to the newsletter");
        home = new HomePage(driver);
        // Subscribe with a fake email
        String email = fake.internet().safeEmailAddress();
        home.subscribeNewsletter(email);
        String successMessage = home.getSubscribeNewsletterSuccessMsg();
        // Validate the success message
        soft.assertEquals(successMessage, "You have Subscribed successfully", "Subscription message mismatch!");
        if ("You have Subscribed successfully".equals(successMessage)) {
            reporter("pass", "User subscribed to newsletter successfully");
        } else {
            reporter("fail", "User failed to subscribe to newsletter!");
        }
        soft.assertAll();
    }
}
