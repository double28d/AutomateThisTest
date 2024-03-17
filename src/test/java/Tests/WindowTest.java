package Tests;

import HelperMethods.ElementMethods;
import HelperMethods.WindowMethods;
import Pages.AlertWindowFramePage;
import Pages.HomePage;
import Pages.WindowPage;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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
