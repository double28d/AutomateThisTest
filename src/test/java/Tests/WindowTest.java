package Tests;

import HelperMethods.ElementMethods;
import HelperMethods.WindowMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WindowTest extends SharedData {

    @Test
    public void windowMethod() {

        ElementMethods elementMethods = new ElementMethods(getWebDriver());
        WindowMethods windowMethods = new WindowMethods(getWebDriver());

        elementMethods.scrollElementByPixel(0,450);

//        WebElement consentField = getWebDriver().findElement(By.className("fc-button-label"));
//        elementMethods.clickElement(consentField);

        WebElement elementsField= getWebDriver().findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickElement(elementsField);

        WebElement browserField= getWebDriver().findElement(By.xpath("//span[text()='Browser Windows']"));
        elementMethods.clickElement(browserField);

        WebElement newTabButton= getWebDriver().findElement(By.id("tabButton"));
        elementMethods.clickElement(newTabButton);

        windowMethods.switchSpecificTabWindow(1);

        //close =  inchide tab-ul curent
        //quit = inchide browser-ul cu toate tab-urile
        windowMethods.closeCurrentTabWindow();
        windowMethods.switchSpecificTabWindow(0);

        WebElement newWindowButton= getWebDriver().findElement(By.id("windowButton"));
        elementMethods.clickElement(newWindowButton);

        windowMethods.switchSpecificTabWindow(1);
        windowMethods.closeCurrentTabWindow();
        windowMethods.switchSpecificTabWindow(0);

        getWebDriver().quit();

    }
}
