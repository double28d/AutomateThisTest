package tests;

import org.testng.annotations.Test;
import pages.AlertWindowFramePage;
import pages.FramePage;
import pages.HomePage;
import sharedData.Hooks;

public class FrameTest extends Hooks {


    @Test
    public void frameMethod() {

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToAlertFrameWindowPage();

        AlertWindowFramePage alertWindowFramePage = new AlertWindowFramePage(getWebDriver());
        alertWindowFramePage.navigateToFramePage();

        FramePage framePage = new FramePage(getWebDriver());
        framePage.dealWithiFrame();

    }
}
