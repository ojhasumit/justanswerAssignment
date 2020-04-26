package org.justanswer;

import base.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pages.CreditCardpage;
import pages.Homepage;
import pages.Questionpage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    String url;
    boolean deleteCookies;
    public static WebDriver driver;
    public Properties properties;
    public CreditCardpage creditCardpage;
    public Homepage chatpage;
    public Questionpage questionpage;

    public BaseTest(){
        properties = new Properties();
        try {
            properties.load(new FileInputStream(getProperties()));
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }


    public String getProperties() {
        String resourceName = "local.env.properties";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(resourceName).getFile());
        String absolutePath = file.getAbsolutePath();

        return absolutePath;
    }

    public WebDriver getDriver() {
        return new WebDriverManager().webdriverSettings("chrome");
    }

    @BeforeClass
    public void setup() {
        driver = getDriver();
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
        if(deleteCookies) {
            driver.manage().deleteAllCookies();
        }
    }


    @AfterClass
    public void tearDown() {
        if(driver!=null) {
            driver.quit();
        }
    }
}
