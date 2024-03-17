package Tests;

import HelperMethods.ElementMethods;
import Pages.ElementPage;
import Pages.HomePage;
import Pages.WebTablePage;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest extends SharedData {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToElementPage();

        ElementPage elementPage = new ElementPage(getWebDriver());
        elementPage.navigateToWebTablePage();

        String firstnameValue = "Gescu";
        String lastnameValue = "Vorbitorul";
        String emailValue = "GSrocks@gSmnj.com";
        String ageValue = "30";
        String salaryValue = "500";
        String departmentValue = "QA";
        String firstNameModify = "George";
        String lastNameModify = "Gutu";

        WebTablePage webTablePage = new WebTablePage(getWebDriver());
        webTablePage.addNewEntry(firstnameValue, lastnameValue, emailValue, ageValue, salaryValue, departmentValue);
        webTablePage.editEntry(firstNameModify, lastNameModify);
        webTablePage.deleteEntry();

    }
}
