package pages;

import loggerUtillity.LoggerUtillity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowPage extends BasePage{
    public WindowPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "tabButton")
    private WebElement newTabButton;
    @FindBy(id = "windowButton")
    private WebElement newWindowButton;

    public void interactWithTabBrowser (){
        elementMethods.clickElement(newTabButton);
        LoggerUtillity.infoTest("The user clicks on newTabButton element");
        windowMethods.switchSpecificTabWindow(1);
        LoggerUtillity.infoTest("The user switch to tab with index 1");
        windowMethods.closeCurrentTabWindow();
        LoggerUtillity.infoTest("The user closes the current tab");
        windowMethods.switchSpecificTabWindow(0);
        LoggerUtillity.infoTest("The user switch to tab with index 0");
    }

    public void interactNewWindow (){
        elementMethods.clickElement(newWindowButton);
        LoggerUtillity.infoTest("The user clicks on newWindowButton element");
        windowMethods.switchSpecificTabWindow(1);
        LoggerUtillity.infoTest("The user switch to tab with index 1");
        windowMethods.closeCurrentTabWindow();
        LoggerUtillity.infoTest("The user closes the current tab");
        windowMethods.switchSpecificTabWindow(0);
        LoggerUtillity.infoTest("The user switch to tab with index 0");
    }
}
