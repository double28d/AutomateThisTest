package pages;

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
        elementMethods.clickElement(alertField);
    }

    public void navigateToFramePage(){
        elementMethods.clickElement(frameField);
    }

    public void navigateToBrowserWindowPage(){
        elementMethods.clickElemForce(browserField);
    }

}
