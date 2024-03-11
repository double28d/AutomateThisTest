package SharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {

    private WebDriver webDriver;

    @BeforeMethod   // => pre-condition
    public void prepareDriver(){
        //Deschidem un browser de Chrome
        webDriver = new ChromeDriver();
        //accesam un URL
        webDriver.get("https://demoqa.com/");
        //maximizarea ferestrei
        webDriver.manage().window().maximize();
        //wait implicit - se pune in mod nromal la inceput de cod asa cum este pus !aici!
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod  // => post-condition
    public void clearDriver(){
        webDriver.quit();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
