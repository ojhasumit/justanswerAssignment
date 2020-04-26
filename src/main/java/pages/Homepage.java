package pages;
import base.*;

import com.google.gson.internal.$Gson$Preconditions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.prefs.PreferenceChangeEvent;

public class Homepage extends BaseTest{

    WebDriver driver;
    Properties properties;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\ril\\IdeaProjects\\justanswer\\src\\test\\resources\\local.env.properties"));
        }catch (IOException exception){
            exception.printStackTrace();
        }
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


    public void chatConversation(String elementString,String text){
        By locator = By.xpath("//div[@class='text' and contains(text(),'"+elementString+"')]");
        if(waitForVisibility(locator,30)){
            chatText.sendKeys(text);
            chatText.sendKeys(Keys.ENTER);
        }
    }

    public void clickContinue() {
        By contineButton = By.xpath("//a[@class='dqt-continue continue-link']");
        waitForVisibility(contineButton,30);
        continueButton.click();
    }

    public void clickFirstQuestion(){
        firstQuestion.get(1).click();
    }
}
