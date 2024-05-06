package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement dialogField;
    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formField;
    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementField;

    public void navigateToAlertFrameWindowPage (){
        elementMethods.scrollElementByPixel(0, 250);
        elementMethods.clickElement(dialogField);
    }

    public void navigateToFormPage(){
        elementMethods.scrollElementByPixel(0, 250);
        elementMethods.clickElement(formField);

    }

    public void navigateToElementPage(){
        elementMethods.scrollElementByPixel(0,350);
        elementMethods.clickElemForce(elementField);
    }

}
