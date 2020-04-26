package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {

    /**
     * TO initiate object of browser
     *
     * @param browser
     * @return
     */
    public WebDriver webdriverSettings(String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.driver.chrome.", "chromedriver");
            return new ChromeDriver();
        }
        return null;
    }
}
