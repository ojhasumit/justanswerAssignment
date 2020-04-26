package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.CreditCardpage;
import pages.Homepage;
import pages.Questionpage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class BaseTest {

    String url;
    String browser;
    boolean deleteCookies;
    public static WebDriver driver;
    public Properties properties;

    public CreditCardpage creditCardpage;
    public Homepage chatpage;
    public Questionpage questionpage;

    public BaseTest(){
        properties = new Properties();


        try {
            properties.load(new FileInputStream("C:\\Users\\ril\\IdeaProjects\\justanswer\\src\\test\\resources\\local.env.properties"));
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    public WebDriver getDriver() {
        return new WebDriverManager().webdriverSettings("chrome");
    }

    @BeforeSuite
    //@Parameters (value = "environment")
    public void setup() {
        driver = getDriver();
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
        if(deleteCookies) {
            driver.manage().deleteAllCookies();
        }
        //driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
    }

    public boolean waitForVisibility(By locator, int timeout){
        try {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @AfterClass
    public void tearDown() {
        if(driver!=null) {
            driver.quit();
        }
    }
}
