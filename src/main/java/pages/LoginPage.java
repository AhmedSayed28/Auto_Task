package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By usernameLocator = By.cssSelector("input[id=\"txtUserName\"]");
    private final By passwordLocator = By.cssSelector("input[id=\"txtPassword\"]");
    private final By loginButtonLocator = By.cssSelector("button[id=\"btnLogin\"]");
    private final By langButtonLocator = By.cssSelector("a[id=\"langLnk\"]");
    private final By copyWriteTextLocator = By.cssSelector("h3[class=\"txt2\"]");
    private final By versionNumberLocator = By.cssSelector("h3[class=\"Matg\"]");
    private final By companyNameLocator = By.cssSelector("p[id=\"Namecompany\"]");

    public void changeLanguage(){
        click(driver.findElement(langButtonLocator));
    }

    public String getCopyWriteText(){
        return driver.findElement(copyWriteTextLocator).getText();
    }

    public String getVersionNumber(){
        return driver.findElement(versionNumberLocator).getText();
    }

    public String getCompanyName(){
        return driver.findElement(companyNameLocator).getText();
    }

    public void login(String username, String password){
        setTextElement(driver.findElement(usernameLocator), username);
        setTextElement(driver.findElement(passwordLocator), password);
        click(driver.findElement(loginButtonLocator));
    }
}
