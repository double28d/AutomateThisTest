package Tests;

import HelperMethods.ElementMethods;
import HelperMethods.FrameMethods;
import Pages.AlertWindowFramePage;
import Pages.FramePage;
import Pages.HomePage;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
