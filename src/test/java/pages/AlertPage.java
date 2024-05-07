package pages;

import loggerUtillity.LoggerUtillity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage{

    public AlertPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "alertButton")
    private WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    private WebElement alertButton2;

    @FindBy(id = "confirmButton")
    private WebElement alertButton3OK;

    @FindBy(id = "confirmResult")
    private WebElement prResult1;

    @FindBy(id = "promtButton")
    private WebElement alertButton4;

    @FindBy(id = "promptResult")
    private WebElement prResult2;

    public void dealWithAcceptAlert(){
        elementMethods.clickElement(alertButton);
        LoggerUtillity.infoTest("The user clicks on alertButton element");
        alertMethods.acceptAlert();
        LoggerUtillity.infoTest("The user accepts the Alert");
    }

    public void dealWithDelayAlert(){
        elementMethods.clickElement(alertButton2);
        LoggerUtillity.infoTest("The user clicks on alertButton2 element");
        alertMethods.acceptAlert();
        LoggerUtillity.infoTest("The user accepts the Alert");
    }

    public void dealWithConfirmButton(){
        elementMethods.clickElement(alertButton3OK);
        LoggerUtillity.infoTest("The user clicks on alertButton3OK element");
        alertMethods.acceptAlert();
        LoggerUtillity.infoTest("The user accepts the Alert");
        elementMethods.validateElementText(prResult1, "You selected Ok");
        LoggerUtillity.infoTest("The user validates the confirm message");


//        alertButton3Cancel.click();
//        Alert thirdtAlertCancel = webDriver.switchTo().alert();
//        thirdtAlertCancel.dismiss();
    }

    public void dealWithPromtButton (String text){
        elementMethods.clickElement(alertButton4);
        LoggerUtillity.infoTest("The user clicks on alertButton4 element");
        alertMethods.fillAlert(text);
        LoggerUtillity.infoTest("The user fills the alert box with the following text: "+text);
    }

}
