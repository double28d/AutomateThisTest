package pages;

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
        alertMethods.acceptAlert();
    }

    public void dealWithDelayAlert(){
        elementMethods.clickElement(alertButton2);
        alertMethods.acceptAlert();
    }

    public void dealWithConfirmButton(){
        elementMethods.clickElement(alertButton3OK);
        alertMethods.acceptAlert();
        elementMethods.validateElementText(prResult1, "You selected Ok");

//        alertButton3Cancel.click();
//        Alert thirdtAlertCancel = webDriver.switchTo().alert();
//        thirdtAlertCancel.dismiss();
    }

    public void dealWithPromtButton (String text){
        elementMethods.clickElement(alertButton4);
        alertMethods.fillAlert(text);
    }

}
