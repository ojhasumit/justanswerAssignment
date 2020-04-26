package pages;
import base.BaseClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Homepage extends BaseClass {

    WebDriver driver;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//textarea[@class='text-area']")
    private WebElement chatText;

    @FindBy(xpath = "//a[@class='dqt-continue continue-link']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@class='dqt-send send-btn disabled']")
    private WebElement send;

    @FindBy(xpath = "//div[@class='text' and contains(text(),'Welcome')]")
    private WebElement welcomeMessage;

    @FindBy(xpath = "//div[@class='text' and contains(text(),'help')]")
    private WebElement helpMessage;

    @FindBy(xpath = "//div[@class='text' and contains(text(),'make')]")
    private WebElement modelChatMessage;

    @FindAll({@FindBy (xpath = "//a[@class='question-link']")})
    private List<WebElement> firstQuestion;

    @Step("Chat Conversation {0} {1}")
    public void chatConversation(String elementString, String text){
        By locator = By.xpath("//div[@class='text' and contains(text(),'"+elementString+"')]");
        if(waitForVisibility(driver, locator,30)){
            chatText.sendKeys(text);
            chatText.sendKeys(Keys.ENTER);
        }
    }

    @Step("Click on Continue for Payment")
    public void clickContinue() {
        By contineButton = By.xpath("//a[@class='dqt-continue continue-link']");
        waitForVisibility(driver, contineButton,30);
        continueButton.click();
    }

    @Step("Click on Question")
    public void clickFirstQuestion(){
        firstQuestion.get(1).click();
    }
}
