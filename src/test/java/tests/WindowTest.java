package tests;

import pages.AlertWindowFramePage;
import pages.HomePage;
import pages.WindowPage;
import sharedData.SharedData;
import org.testng.annotations.Test;

public class WindowTest extends SharedData {

    @Test
    public void windowMethod() {
        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToAlertFrameWindowPage();

        AlertWindowFramePage alertWindowFramePage = new AlertWindowFramePage(getWebDriver());
        alertWindowFramePage.navigateToBrowserWindowPage();

        WindowPage windowPage = new WindowPage(getWebDriver());
        windowPage.interactWithTabBrowser();
        windowPage.interactNewWindow();

    }
}
