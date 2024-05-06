package tests;

import objectData.WebTableObject;
import pages.ElementPage;
import pages.HomePage;
import pages.WebTablePage;
import propertyUtility.PropertyUtility;
import sharedData.SharedData;
import org.testng.annotations.Test;

public class WebTableTest extends SharedData {

    @Test
    public void metodaTest() {

        PropertyUtility propertyUtility = new PropertyUtility("WebTableData");
        WebTableObject webTableObject = new WebTableObject(propertyUtility.getAllData());

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToElementPage();

        ElementPage elementPage = new ElementPage(getWebDriver());
        elementPage.navigateToWebTablePage();

        WebTablePage webTablePage = new WebTablePage(getWebDriver());
        webTablePage.addNewEntry(webTableObject);
        webTablePage.editEntry(webTableObject);
        webTablePage.deleteEntry();

    }
}
