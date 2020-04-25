package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {

    WebDriver driver;

    public void webdriverSettings(String browser){
        driver = null;

        if(browser.equals("chrome"))
        System.setProperty("webdriver.driver.chrome.","chromedriver.exe");
        driver = new ChromeDriver();
    }
}
