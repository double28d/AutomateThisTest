package pages;

import loggerUtillity.LoggerUtillity;
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
        LoggerUtillity.infoTest("The user scroll down the page");
        elementMethods.clickElement(dialogField);
        LoggerUtillity.infoTest("The user clicks on windowFiled element");

    }

    public void navigateToFormPage(){
        elementMethods.scrollElementByPixel(0, 250);
        LoggerUtillity.infoTest("The user scroll down the page");
        elementMethods.clickElement(formField);
        LoggerUtillity.infoTest("The user clicks on formFiled element");

    }

    public void navigateToElementPage(){
        elementMethods.scrollElementByPixel(0,350);
        LoggerUtillity.infoTest("The user scroll down the page");
        elementMethods.clickElemForce(elementField);
        LoggerUtillity.infoTest("The user clicks on elementFiled element");
    }

}
