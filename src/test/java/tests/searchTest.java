package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;

public class searchTest extends TestBase{

    MainPage main;
    SoftAssert soft = new SoftAssert();
    @Test
    public void TC_001() throws InterruptedException {
        logger = extent.createTest("Verify TestNG is visible");

        main = new MainPage(driver);

        main.search();

        if (main.getFourthText().contains("testng")){
            reporter("pass","TestNG is visible successfully");
        }else {
            reporter("fail","TestNG is not visible");
        }
    }


}
