package pages;

import loggerUtillity.LoggerUtillity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage{

    public FramePage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(id = "sampleHeading")
    private WebElement frameElement;

    public void dealWithiFrame(){
        frameMethods.switchSpecificIframe("frame1");
        LoggerUtillity.infoTest("The user switch to a specific iFrame");
        elementMethods.printElementText(frameElement);
        LoggerUtillity.infoTest("The user interacts with the text of the frameElement ");
        frameMethods.switchParentFrame();
        LoggerUtillity.infoTest("The user switch to default frame");

        frameMethods.switchSpecificIframe("frame2");
        LoggerUtillity.infoTest("The user switch to a specific iFrame");
        elementMethods.printElementText(frameElement);
        LoggerUtillity.infoTest("The user interacts with the text of the frameElement ");
    }
}
