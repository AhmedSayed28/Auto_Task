package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.InternApplyNowForm;
import pages.NavBar;

public class InternApplyNowTest extends TestBase {

    private InternApplyNowForm applyForm;
    private NavBar navBar;
    private final Faker faker = new Faker();

    // Test data generated using Faker
    private final String fullName = faker.name().fullName();
    private final String email = faker.internet().safeEmailAddress();
    private final String phone = String.valueOf(faker.number().numberBetween(1000000, 99999999));
    private final String address = faker.address().fullAddress();
    private final String degreeAndYear = faker.educator().course() + ", " + faker.number().numberBetween(1900, 2024);

    @Test
    public void testInternApplyNowForm() throws InterruptedException {
        logger = extent.createTest("Verify Intern can apply successfully");

        // Initialize page objects
        applyForm = new InternApplyNowForm(driver);
        navBar = new NavBar(driver);

        // Navigate to the "Apply Now" page
        navBar.navigateToApplyNowPage();

        // Fill out phase one of the form
        String gender = "Male";
        applyForm.fillPhaseOne(fullName, email, address, gender, phone, degreeAndYear);
        reporter("pass", "The first step has been completed successfully");

        // Fill out phase two of the form
        applyForm.fillPhaseTwo("Frontend Developer");
        reporter("pass", "The second step has been completed successfully");

        // Fill out phase three of the form and upload a test file
        applyForm.fillPhaseThree("C:\\Users\\qaahm\\Downloads\\test.pdf", "This is a note for the application.");
        Thread.sleep(1000);
        reporter("pass", "Intern application has been submitted successfully");

    }
}
