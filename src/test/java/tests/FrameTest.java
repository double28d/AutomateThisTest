package tests;

import pages.AlertWindowFramePage;
import pages.FramePage;
import pages.HomePage;
import sharedData.SharedData;
import org.testng.annotations.Test;

public class FrameTest extends SharedData {


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
