package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Base{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final By searchInputLocator = By.xpath("//input[@id=\"searchbox_input\"]");
    private final By submitSearchButton = By.xpath("//button[@class=\"iconButton_button__6x_9C searchbox_searchButton__F5Bwq\"]");
    private final By fourthResultText = By.xpath(" //article[@id=\"r1-3\"] //div[2] //a");



    public void search(){
        setTextElement(driver.findElement(searchInputLocator), "TestNG");
        click(submitSearchButton);
    }

    public String getFourthText(){
        return driver.findElement(fourthResultText).getText().toLowerCase();
    }
}
