package Tests;

import HelperMethods.ElementMethods;
import Pages.FormPage;
import Pages.HomePage;
import Pages.PracticeFormPage;
import SharedData.SharedData;
import com.beust.ah.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToFormPage();

        FormPage formPage = new FormPage(getWebDriver());
        formPage.navigateToPracticeForm();

        String firstnameValue = "Daniel";
        String lastNameValue = "Danilov";
        String userEmailValue = "GSJR@yahh.org";
        String userMobileNumberValue = "1234567890";
        String monthValue = "January";
        String yearValue = "1994";
        String dayValue = "28";
        String genderValue = "Male";
        List <String> hobbies = Arrays.asList("Sports","Music","Reading");
        String subjectValue = "English";
        String filePath = "src/test/resources/tree.jpg";
        String currentAddressFieldValue = ("str.gojnea 23");
        String stateValue = "NCR";
        String cityValue = "Delhi";


        PracticeFormPage practiceFormPage = new PracticeFormPage(getWebDriver());
        practiceFormPage.fillEntireForm(firstnameValue, lastNameValue, userEmailValue, userMobileNumberValue, monthValue,
                yearValue, dayValue, genderValue, hobbies, subjectValue, filePath, currentAddressFieldValue, stateValue, cityValue);
        practiceFormPage.validatePracticeFormTable(firstnameValue, lastNameValue, userEmailValue, genderValue,
                userMobileNumberValue, subjectValue, hobbies, filePath, currentAddressFieldValue, stateValue, cityValue);


    }
}