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
        String subjectValue = "Engineer";
        String filePath = "src/test/resources/tree.jpg";
        String currentAddressFieldValue = ("str.gojnea 23");


        PracticeFormPage practiceFormPage = new PracticeFormPage(getWebDriver());
        practiceFormPage.fillFirstName(firstnameValue);
        practiceFormPage.fillLastName(lastNameValue);
        practiceFormPage.fillUserEmail(userEmailValue);
        practiceFormPage.fillMobileNumber(userMobileNumberValue);
        practiceFormPage.fillBirthDay(monthValue,yearValue,dayValue);
        practiceFormPage.pickGender(genderValue);
        practiceFormPage.pickHobbies(hobbies);
        practiceFormPage.pickSubject(subjectValue);
        practiceFormPage.pickPicture(filePath);
        practiceFormPage.setCurrentAddressField(currentAddressFieldValue);


//        WebElement stateField = getWebDriver().findElement(By.id("react-select-3-input"));
//        elementMethods.scrollElementByPixel(0,450);
//
//        String stateValue = "NCR";
//        elementMethods.fillPressElement(stateField,stateValue,Keys.ENTER);
//
//        WebElement cityInputField = getWebDriver().findElement(By.id("react-select-4-input"));
//        String cityValue = "Delhi";
//        elementMethods.fillPressElement(cityInputField,cityValue,Keys.ENTER);
//
//        elementMethods.scrollElementByPixel(0,450);
//
//        WebElement submitButton = getWebDriver().findElement(By.id("submit"));
//        elementMethods.clickElement(submitButton);
////
////        // Validam tabelul cu valori
//        List<WebElement> labelFields = getWebDriver().findElements(By.xpath("//table/tbody/tr/td[1]"));
//        List<WebElement> valuelFields = getWebDriver().findElements(By.xpath("//table/tbody/tr/td[2]"));
//
//        Assert.assertEquals(labelFields.get(0).getText(),"Student Name");
//        Assert.assertEquals(valuelFields.get(0).getText(),firstnameValue + " " + lastNameValue);
//
//        Assert.assertEquals(labelFields.get(1).getText(),"Student Email");
//        Assert.assertEquals(valuelFields.get(1).getText(),userEmailValue);
//
//        Assert.assertEquals(labelFields.get(2).getText(),"Gender");
//        Assert.assertEquals(valuelFields.get(2).getText(),"Male");
//
//        Assert.assertEquals(labelFields.get(3).getText(),"Mobile");
//        Assert.assertEquals(valuelFields.get(3).getText(),userMobileNumberValue);
//
//        Assert.assertEquals(labelFields.get(4).getText(),"Date of Birth");
////        Assert.assertEquals(valuelFields.get(4).getText(),);
//
//        Assert.assertEquals(labelFields.get(5).getText(),"Subjects");
//        Assert.assertEquals(valuelFields.get(5).getText(),subjectValue);
//
//        Assert.assertEquals(labelFields.get(6).getText(),"Hobbies");
//        for (Integer index=0; index<Hobbies.size(); index++) {
//            Assert.assertTrue(valuelFields.get(6).getText().contains(Hobbies.get(index)));
//        }
//
//        Assert.assertEquals(labelFields.get(7).getText(),"Picture");
//        String[] arrayFile= filePath.split("/");
//        Integer desireIndex= arrayFile.length - 1;
//        Assert.assertEquals(valuelFields.get(7).getText(),arrayFile[desireIndex]);
//
//        Assert.assertEquals(labelFields.get(8).getText(),"Address");
//        Assert.assertEquals(valuelFields.get(8).getText(),currentAddressFieldValue);
//
//        Assert.assertEquals(labelFields.get(9).getText(),"State and City");
//        Assert.assertEquals(valuelFields.get(9).getText(),stateValue + " " + cityValue);




//        JavascriptExecutor scroll4 = (JavascriptExecutor) webDriver;
//        js.executeScript("window.scrollBy(0,450)", "");
//
//        WebElement closeButton= webDriver.findElement(By.id("closeLargeModal"));
//        js.executeScript("arguments[0].click();", closeButton);

    }
}