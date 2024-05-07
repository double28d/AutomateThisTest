package tests;

import org.testng.annotations.Test;
import pages.AlertWindowFramePage;
import pages.HomePage;
import pages.WindowPage;
import sharedData.Hooks;

public class WindowTest extends Hooks {

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
