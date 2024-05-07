package pages;

import loggerUtillity.LoggerUtillity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertWindowFramePage extends BasePage {

    public AlertWindowFramePage(WebDriver webDriver) {
       super(webDriver);
    }
    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertField;
    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement frameField;
    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserField;

//    public AlertWindowFramePage(WebDriver webDriver)

    public void navigateToAlertPage(){
        elementMethods.scrollElementByPixel(0, 450);
        LoggerUtillity.infoTest("The user scroll down the page");
        elementMethods.clickElement(alertField);
        LoggerUtillity.infoTest("The user clicks on alertField element");
    }

    public void navigateToFramePage(){
        elementMethods.clickElement(frameField);
        LoggerUtillity.infoTest("The user clicks on frameField element");
    }

    public void navigateToBrowserWindowPage(){
        elementMethods.clickElemForce(browserField);
        LoggerUtillity.infoTest("The user clicks on browserField element");
    }

}
