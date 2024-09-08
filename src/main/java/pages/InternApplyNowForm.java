package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InternApplyNowForm extends Base {

    // Locators for phase one
    private final By fullNameInputLocator = By.cssSelector("input[id=\"fullNameIntern\"]");
    private final By emailInputLocator = By.cssSelector("input[id=\"emailAddressIntern\"]");
    private final By addressInputLocator = By.cssSelector("input[id=\"addressIntern\"]");
    private final By genderSelectBoxLocator = By.cssSelector("select[id=\"genderIntern\"]");
    private final By phoneInputLocator = By.cssSelector("input[id=\"txtPhoneIntern\"]");
    private final By degreeAndGradYearInputLocator = By.cssSelector("input[id=\"degreeIntern\"]");
    private final By nextBtnLocator = By.cssSelector("form[id=\"intern-form\"] div[class=\"modal-footer border-0\"] button");

    // Locators for phase two
    private final By prevExLocator = By.cssSelector("input[id=\"previousExperienceIntern\"]");
    private final By selectProgramLocator = By.cssSelector("select[id=\"programIntern\"]");
    private final By selectTrainingTimeLocator = By.cssSelector("select[id=\"trainingTimeIntern\"]");
    private final By selectTechnicalSkillsLocator = By.cssSelector("select[id=\"technicalSkillsIntern\"]");
    private final By selectTrainingPeriodLocator = By.cssSelector("select[id=\"trainingPeriodIntern\"]");
    private final By selectOfficeOrRemoteLocator = By.cssSelector("select[id=\"officeIntern\"]");
    private final By next2BtnLocator = By.cssSelector("form[id=\"intern-form\"] div[class=\"modal-footer border-0\"] div[class=\"apply-job-step-two\"] button[id=\"job-next-btn\"]");

    // Locators for phase three
    private final By uploadFileLocator = By.cssSelector("input[id=\"attachFileIntern\"]");
    private final By noteInputLocator = By.cssSelector("textarea[id=\"notesIntern\"]");
    private final By sendBtnLocator = By.cssSelector("form[id=\"intern-form\"] div[class=\"apply-job-step-three\"] button[id=\"intern-send-btn\"]");

    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public InternApplyNowForm(WebDriver driver) {
        super(driver);
    }

    // Fill out phase one of the application form
    public void fillPhaseOne(String name, String email, String address, String gender, String phone, String degreeAndYear) {
        setTextElement(driver.findElement(fullNameInputLocator), name);
        setTextElement(driver.findElement(emailInputLocator), email);
        setTextElement(driver.findElement(addressInputLocator), address);
        selectByVisibleText(genderSelectBoxLocator, gender);
        setTextElement(driver.findElement(phoneInputLocator), phone);
        setTextElement(driver.findElement(degreeAndGradYearInputLocator), degreeAndYear);
        click(nextBtnLocator);
    }

    // Fill out phase two of the application form
    public void fillPhaseTwo(String previousExperience) {
        setTextElement(driver.findElement(prevExLocator), previousExperience);
        selectByIndex(selectProgramLocator, 1);
        selectByIndex(selectTrainingTimeLocator, 1);
        selectByIndex(selectTechnicalSkillsLocator, 1);
        selectByIndex(selectTrainingPeriodLocator, 1);
        selectByIndex(selectOfficeOrRemoteLocator, 1);
        click(next2BtnLocator);
    }

    // Fill out phase three of the application form
    public void fillPhaseThree(String filePath, String note) {
        driver.findElement(uploadFileLocator).sendKeys(filePath);
        setTextElement(driver.findElement(noteInputLocator), note);
        click(sendBtnLocator);
    }

    // Helper method to select an option by visible text
    private void selectByVisibleText(By locator, String text) {
        new Select(driver.findElement(locator)).selectByVisibleText(text);
    }

    // Helper method to select an option by index
    private void selectByIndex(By locator, int index) {
        new Select(driver.findElement(locator)).selectByIndex(index);
    }

    private void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
