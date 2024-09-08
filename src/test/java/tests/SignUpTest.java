package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RegisterFormPage;

public class SignUpTest extends TestBase {

    private final Faker fake = new Faker();
    private final SoftAssert soft = new SoftAssert();

    // Test data generated using Faker
    private final String firstName = fake.name().firstName();
    private final String lastName = fake.name().lastName();
    private final String course = "Selenium Automation";
    private final String phone = String.valueOf(fake.number().numberBetween(1111111111, 999999999));
    private final String month = "April";
    private final String email = fake.internet().safeEmailAddress();

    @Test
    public void testCase_001() throws InterruptedException {
        logger = extent.createTest("Verify User can register successfully");
        RegisterFormPage reg = new RegisterFormPage(driver);

        // Fill the sign-up form with test data
        reg.fillSignUpForm(firstName, lastName, course, phone, email, month);

        // Logging test data for debugging
        reporter("info", "User first name is: " + firstName);
        reporter("info", "User last name is: " + lastName);
        reporter("info", "User selected course: " + course + " in " + month);
        reporter("info", "User phone is: " + phone);
        reporter("info", "User email is: " + email);

        // Validate the success message
        String successMsg = reg.getSuccessMsg();
        soft.assertEquals(successMsg, "Your registration is completed. We will contact with you soon. Thank you !");

        // Report pass/fail based on success message
        if ("Your registration is completed. We will contact with you soon. Thank you !".equals(successMsg)) {
            reporter("pass", "Registration completed successfully.");
        } else {
            reporter("fail", "User could not register.");
        }

        soft.assertAll();
    }
}
