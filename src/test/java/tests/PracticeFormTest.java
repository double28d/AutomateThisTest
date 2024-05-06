package tests;

import objectData.PracticeFormObject;
import pages.FormPage;
import pages.HomePage;
import pages.PracticeFormPage;
import propertyUtility.PropertyUtility;
import sharedData.SharedData;
import org.testng.annotations.Test;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {

        PropertyUtility propertyUtility = new PropertyUtility("PracticeFormData");
        PracticeFormObject practiceFormObject = new PracticeFormObject(propertyUtility.getAllData());

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToFormPage();

        FormPage formPage = new FormPage(getWebDriver());
        formPage.navigateToPracticeForm();

        PracticeFormPage practiceFormPage = new PracticeFormPage(getWebDriver());

        practiceFormPage.fillEntireForm(practiceFormObject);
        practiceFormPage.validatePracticeFormTable(practiceFormObject);

    }
}