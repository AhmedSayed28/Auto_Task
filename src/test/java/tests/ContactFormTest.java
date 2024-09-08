package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.NavBar;

public class ContactFormTest extends TestBase {

    private ContactPage contactPage;
    private NavBar navBar;
    private final Faker faker = new Faker();

    // Fake data for contact form fields
    private final String firstName = faker.name().firstName();
    private final String email = faker.internet().safeEmailAddress();
    private final String phone = String.valueOf(faker.number().numberBetween(1000000, 99999999));
    private final String subject = faker.lorem().paragraph(2);
    private final String message = faker.lorem().paragraph(4);

    @Test
    public void testContactFormSubmission() throws InterruptedException {
        logger = extent.createTest("Verify User can Contact us successfully");

        // Initialize page objects
        contactPage = new ContactPage(driver);
        navBar = new NavBar(driver);

        // Navigate to the Contact Us page
        navBar.navigateToContactUsPage();

        // Fill and submit the contact form
        contactPage.fillContactFormWithValidData(firstName, email, phone, subject, message);

        // Verify if the success message is displayed
        if (contactPage.isSuccess()) {
            reporter("pass", "Your message has been sent successfully. We will contact you as soon as possible. Thank you!");
        } else {
            reporter("fail", "User could not send their message!");
        }
    }
}
