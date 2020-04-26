package pages;

import base.BaseClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Questionpage extends BaseClass {

    WebDriver driver;
    public Questionpage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='ja-button-orange ask-question']")
    private WebElement askYourQuestion;
    String askQuestion = "//div[@class='ja-button-orange ask-question']";

    @Step("Ask your Question")
    public void clickOnAskYourQuestion(){
        By askYourQuestion = By.xpath(askQuestion);
        waitForVisibility(driver, askYourQuestion,30);
    }
}
