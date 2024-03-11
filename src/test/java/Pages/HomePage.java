package Pages;

import HelperMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

//    @FindBy(className = "fc-button-label")
//    public WebElement consentField;
    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement elementsField;



    public void navigateToAlertFrameWindowPage (){
        elementMethods.scrollElementByPixel(0, 250);
//        elementMethods.clickElement(consentField);
        elementMethods.clickElement(elementsField);
    }

}
