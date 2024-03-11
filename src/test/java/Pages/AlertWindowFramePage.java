package Pages;

import HelperMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertWindowFramePage extends BasePage {

    public AlertWindowFramePage(WebDriver webDriver) {
       super(webDriver);
    }
    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement browserField;

    public void navigateToAlertPage(){
        elementMethods.scrollElementByPixel(0, 450);
        elementMethods.clickElement(browserField);

    }

}
