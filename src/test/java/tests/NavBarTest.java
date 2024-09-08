package tests;

import org.testng.annotations.Test;
import pages.NavBar;

public class NavBarTest extends TestBase {

    private NavBar nav;

    @Test
    public void testNavigationOnPages() throws InterruptedException {
        logger = extent.createTest("Verify User can navigate on all website pages");
        nav = new NavBar(driver);

        // Navigate to the About page
        nav.navigateToAboutPage();
        reporter("pass", "User navigated to About Us page successfully");

        // Navigate to the Solutions page
        nav.navigateToSolutionsPage();
        reporter("pass", "User navigated to Solutions page successfully");

        // Navigate to the Use Case page
        nav.navigateToUseCasePage();
        reporter("pass", "User navigated to Use Case page successfully");

        // Navigate to the Blog page
        nav.navigateToBlogPage();
        reporter("pass", "User navigated to Blog page successfully");

        // Navigate to the Careers page
        nav.navigateToCareerPage();
        reporter("pass", "User navigated to Careers page successfully");
    }
}
