package pages;

import base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Questionpage extends BaseTest {

    WebDriver driver;
    public Questionpage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='ja-button-orange ask-question']")
    private WebElement askYourQuestion;

    @Step("Ask your Question {0}")
    public void clickOnAskYourQuestion(){
        By askYourQuestion = By.xpath("//div[@class='ja-button-orange ask-question']");
        waitForVisibility(askYourQuestion,30);
    }
}
