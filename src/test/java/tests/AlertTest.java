package tests;

import pages.AlertPage;
import pages.AlertWindowFramePage;
import pages.HomePage;
import sharedData.Hooks;
import sharedData.SharedData;
import org.testng.annotations.Test;

public class AlertTest extends Hooks {


    @Test
    public void alertMethod() {

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToAlertFrameWindowPage();

        AlertWindowFramePage alertWindowFramePage = new AlertWindowFramePage(getWebDriver());
        alertWindowFramePage.navigateToAlertPage();

        AlertPage alertPage = new  AlertPage(getWebDriver());
        alertPage.dealWithAcceptAlert();
        alertPage.dealWithDelayAlert();
        alertPage.dealWithConfirmButton();
        alertPage.dealWithPromtButton("Automate this Test");

    }
}
