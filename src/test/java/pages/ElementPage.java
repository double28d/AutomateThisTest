package pages;

import loggerUtillity.LoggerUtillity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementPage extends BasePage{
    public ElementPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    private WebElement webTablesField;

    public void navigateToWebTablePage(){
        elementMethods.clickElement(webTablesField);
        LoggerUtillity.infoTest("The user clicks on webTablesField element");
    }




}
