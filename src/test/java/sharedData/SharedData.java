package sharedData;

import sharedData.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SharedData {

    private WebDriver webDriver;

    @BeforeMethod   // => pre-condition
    public void prepareDriver(){
        webDriver = new BrowserFactory().getBrowserInstance();
    }

    @AfterMethod  // => post-condition
    public void clearDriver(){
        webDriver.quit();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
