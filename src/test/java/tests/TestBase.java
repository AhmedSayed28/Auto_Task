package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
public class TestBase {


    public static boolean executeBeforeMethod = true;
    protected static ExtentReports extent;
    protected static ExtentSparkReporter reporter;
    protected static ExtentTest logger;

    static WebDriver driver;



    public static void reporter(String status, String stepDetail) throws InterruptedException {

        //ExtentTest logger = null;
        Thread.sleep(1000);
        String base64Screenshot;
        try {
            base64Screenshot = HelperClass.capture(driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (status.equalsIgnoreCase("pass")) {
            logger.pass(stepDetail, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        } else if (status.equalsIgnoreCase("fail")) {
            logger.fail(stepDetail, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        } else if (status.equalsIgnoreCase("info")) {
            logger.info(stepDetail);
        } else if (status.equalsIgnoreCase("Warning")) {
            logger.warning(stepDetail);
        }
    }
    @BeforeSuite
    public void setUpSuite() throws IOException {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Reports/extent-report.html");
        spark.loadJSONConfig(new File("Reports/extent-reports-config.json"));

        extent.attachReporter(spark);
    }
    @BeforeMethod
    public void setUp() {
        reporter = new ExtentSparkReporter("Reports/extent-report.html");
        extent.attachReporter(reporter);

        // Initialize the WebDriver instance
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion","126.0.6478.126");
        driver.manage().window().maximize();
        if (executeBeforeMethod) {
            driver.get("https://stg.wakeb.tech/en");
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "Reports/screenshots/" + result.getName() + ".png";
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
            logger.fail("Test Failed. See screenshot below:");
            logger.fail(result.getThrowable());
            logger.addScreenCaptureFromPath(screenshotPath);
        }
        Thread.sleep(3000);
        driver.quit();
    }


    @AfterSuite
    public void tearDownSuite() throws IOException {
        // Flush the ExtentReports instance to generate the report
        extent.flush();
        Desktop.getDesktop().open(new File("Reports/extent-report.html"));
    }
    }
