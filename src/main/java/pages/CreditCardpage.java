package pages;

import base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreditCardpage extends BaseTest {

    WebDriver driver;

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement emailId;

    @FindBy(xpath = "//input[@id='input-card-number']")
            private WebElement cardNumber;

    @FindBy(xpath = "//input[@id='card-dateinput']")
            private WebElement expiryDate;

    @FindBy(xpath = "//input[@id='input-card-cvv']")
            private WebElement cvv;

    @FindBy(xpath = "//input[@id='input-card-zip']")
            private WebElement zip;

    @FindBy(xpath = "//button[@id='cta-form-submit']")
            private WebElement submit;

    @FindBy(xpath = "//p[@class='form__field-error is-active' and contains(text(),'email')]")
            private WebElement emailError;

    @FindBy(xpath = "//p[@class='form__field-error is-active' and contains(text(),'card')]")
            private WebElement cardError;

    @FindBy(xpath = "//p[@class='form__field-error is-active' and contains(text(),'expiration')]")
            private WebElement expiryError;

    @FindBy(xpath = "//p[@class='form__field-error is-active' and contains(text(),'format')]")
            private WebElement expiryFormatError;

    @FindBy(xpath = "//p[@class='form__field-error is-active' and contains(text(),'security')]")
            private WebElement cvvError;

    @FindBy(xpath = "//p[@class='form__field-error is-active' and contains(text(),'zip')]")
            private WebElement zipError;

    @FindAll({@FindBy(xpath ="//select[@class='dropdown__original-select js-dropdown-select']")})
            private List<WebElement> expiryDateDropdown;

    String options = "//div[@class='dropdown__option' and text() = '%1s']";
    String dropDown = "//div[@class='dropdown__current js-dropdown-current' and text() = '%1s']";


    public CreditCardpage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


     @Step("Enter email {0}")
    public void enterEmail(String email){
        By email_id = By.xpath("//input[@id='input-email']");
        waitForVisibility(email_id,30);
        emailId.sendKeys(email);
    }

     @Step("Enter card details {0}")
    public void enterCardDetails(String card_Number){
//        By creditcardTextBox = By.xpath("//input[@id='input-card-number']");
//        waitForVisibility(creditcardTextBox,30);
        cardNumber.sendKeys(card_Number);
    }
    public void enterExpiry(String expiry_Date){
        expiryDate.sendKeys(expiry_Date);
    }
    public void enterCVV(String cvv_detail){
        cvv.sendKeys(cvv_detail);
    }
    public void enterZip(String postal){
        zip.sendKeys(postal);
    }
    public void clickSubmit(){
        By submitButton = By.xpath("//button[@id='cta-form-submit']");
        waitForVisibility(submitButton,30);
        submit.click();
    }
    public String getEmailError(){
       return emailError.getText();
    }
    public String getExpiryError(){
        return expiryError.getText();
    }
    public String getExpiryFormatError(){
        return expiryFormatError.getText();
    }
    public String getCVVError(){
        return cvvError.getText();
    }
    public String getCardError(){
        return cardError.getText();
    }
    public String getzipError(){
        return zipError.getText();
    }
        public void selectExpiryDateandYear(String month, String year){
            WebElement monthDropDown =  driver.findElement(By.xpath(String.format(dropDown, "Month")));
            WebElement yearDropDown =  driver.findElement(By.xpath(String.format(dropDown, "Year")));
            WebElement monthElement = driver.findElement(By.xpath(String.format(options,month)));
            WebElement yearElement = driver.findElement(By.xpath(String.format(options,year)));
            monthDropDown.click();
            monthElement.click();
            yearDropDown.click();
            yearElement.click();

        }
}