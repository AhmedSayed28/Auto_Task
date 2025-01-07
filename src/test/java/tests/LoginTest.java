package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

public class LoginTest extends TestBase {

    LoginPage loginPage;
    SoftAssert soft = new SoftAssert();


    @Test
    public void loginTest() throws InterruptedException {
        logger = extent.createTest("Verify Login functionality Works as expected");
        loginPage = new LoginPage(driver);
        loginPage.login("01159313034", "Abc_123");
        soft.assertFalse(driver.getCurrentUrl().contains("login"), "Login Failed");
        reporter("pass", "Login Successful");
    }

    @Test
    public void changeLanguageTest() throws InterruptedException {
        logger = extent.createTest("Verify Language Change functionality Works as expected");
        loginPage = new LoginPage(driver);
        loginPage.changeLanguage();
        reporter("fail", "Language Change Failed");
    }

    @Test
    public void getCopyWriteTextTest() throws InterruptedException {
        logger = extent.createTest("Verify CopyWrite Text is displayed");
        loginPage = new LoginPage(driver);
        soft.assertEquals(loginPage.getCopyWriteText(), " الحقوق محفوظة © متجري 2017 - 2025 ", "CopyWrite Text is not displayed");
        reporter("fail", "CopyWrite Text is not correct");
    }

    @Test
    public void getVersionNumberTest() throws InterruptedException {
        logger = extent.createTest("Verify Version Number is displayed");
        loginPage = new LoginPage(driver);
        soft.assertEquals(loginPage.getVersionNumber(), " برنامج متجري - الإصدار 3.5.10", "Version Number is not displayed");
        reporter("fail", "Version Number is not correct");
    }

    @Test
    public void getCompanyNameTest() throws InterruptedException {
        logger = extent.createTest("Verify Company Name is displayed");
        loginPage = new LoginPage(driver);
        soft.assertEquals(loginPage.getCompanyName(), "مؤسسة قوة العروبة سوفت\n" +
                "0550300710/0553992909/0550400512", "Company Name is not displayed");
        reporter("fail", "Company Name is not correct");
    }

}
