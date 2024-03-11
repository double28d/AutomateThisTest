package Tests;

import HelperMethods.ElementMethods;
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
        ElementMethods elementMethods = new ElementMethods(getWebDriver());

        elementMethods.scrollElementByPixel(0,450);

        //identificam un element
//        WebElement consentField = getWebDriver().findElement(By.className("fc-button-label"));
//        elementMethods.clickElement(consentField);

        WebElement elementsField = getWebDriver().findElement(By.xpath("//h5[text()='Forms']"));
        elementMethods.clickElement(elementsField);

        elementMethods.scrollElementByPixel(0,250);

        WebElement webTablesField = getWebDriver().findElement(By.xpath("//span[text()='Practice Form']"));
        elementMethods.clickElement(webTablesField);

        WebElement firstnameField = getWebDriver().findElement(By.id("firstName"));
        String firstnameValue = "Daniel";
        elementMethods.fillElement(firstnameField,firstnameValue);

        WebElement lastNameField = getWebDriver().findElement(By.cssSelector("input[placeholder='Last Name']"));
        String lastNameValue = "Danilov";
        elementMethods.fillElement(lastNameField,lastNameValue);

        WebElement userEmail = getWebDriver().findElement(By.id("userEmail"));
        String userEmailValue = "GSJR@yahh.org";
        elementMethods.fillElement(userEmail,userEmailValue);

        WebElement userMobileNumber = getWebDriver().findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String userMobileNumberValue = "1234567890";
        elementMethods.fillElement(userMobileNumber,userMobileNumberValue);

        elementMethods.scrollElementByPixel(0,250);

        WebElement dateOfBirthField = getWebDriver().findElement(By.id("dateOfBirthInput"));
        elementMethods.clickElement(dateOfBirthField);

        WebElement mounthDateOfBirth = getWebDriver().findElement(By.cssSelector(".react-datepicker__month-select"));
        String monthValue = "January";
        elementMethods.selectTextElement(mounthDateOfBirth, monthValue);

        WebElement yearField = getWebDriver().findElement(By.cssSelector(".react-datepicker__year-select"));
        String yearValue = "1994";
        elementMethods.selectValueElement(yearField,yearValue);

        List<WebElement> dayDateOfBirthFields = getWebDriver().findElements(By.xpath("//div[not(contains(@class, " +
                "'react-datepicker__day--outside-month')) "
                + "and contains (@class, 'react-datepicker__day react-datepicker__day')]"));
        String dayValue = "28";
        for (Integer index = 0; index < dayDateOfBirthFields.size(); index++){
            if (dayDateOfBirthFields.get(index).getText().equals(dayValue)){
                dayDateOfBirthFields.get(index).click();
                break;
            }
        }

        ////div[not(contains(@class, 'outside-month')) and contains(@class, 'react-datepicker__day react-datepicker__day')]

        WebElement userGenderField= getWebDriver().findElement(By.cssSelector("label[for='gender-radio-1']"));
        String genderValue = "Male";
        userGenderField.click();

        WebElement subjectsField = getWebDriver().findElement(By.id("subjectsInput"));
        String subjectValue = "Economics";
        elementMethods.fillPressElement(subjectsField,subjectValue, Keys.ENTER);

        //facem un algoritm care sa imi selecteze valorile pe care i le specific

        List<String> Hobbies = Arrays.asList("Sports","Music","Reading");
        List<WebElement> HobbysList = getWebDriver().findElements(By.xpath("//div[@id='hobbiesWrapper']//label[@class='custom-control-label']"));
        for (Integer index=0; index<HobbysList.size(); index++){
            String currentElementText = HobbysList.get(index).getText();
            if (Hobbies.contains(currentElementText)){
                HobbysList.get(index).click();
            }
        }

        WebElement pictureField = getWebDriver().findElement(By.id("uploadPicture"));
        String filePath = "src/test/resources/tree.jpg";
        elementMethods.fillElement(pictureField, new File(filePath).getAbsolutePath());

        WebElement currentAddressField = getWebDriver().findElement(By.cssSelector("textarea[placeholder='Current Address']"));
        String currentAddressFieldValue = ("str.gojnea 23");
        elementMethods.fillElement(currentAddressField,currentAddressFieldValue);

        elementMethods.scrollElementByPixel(0,450);

        WebElement stateField = getWebDriver().findElement(By.id("react-select-3-input"));
        elementMethods.scrollElementByPixel(0,450);

        String stateValue = "NCR";
        elementMethods.fillPressElement(stateField,stateValue,Keys.ENTER);


        WebElement cityInputField = getWebDriver().findElement(By.id("react-select-4-input"));
        String cityValue = "Delhi";
        elementMethods.fillPressElement(cityInputField,cityValue,Keys.ENTER);

        elementMethods.scrollElementByPixel(0,450);

        WebElement submitButton= getWebDriver().findElement(By.id("submit"));
        elementMethods.clickElement(submitButton);
//
//        // Validam tabelul cu valori
        List<WebElement> labelFields= getWebDriver().findElements(By.xpath("//table/tbody/tr/td[1]"));
        List<WebElement> valuelFields= getWebDriver().findElements(By.xpath("//table/tbody/tr/td[2]"));

        Assert.assertEquals(labelFields.get(0).getText(),"Student Name");
        Assert.assertEquals(valuelFields.get(0).getText(),firstnameValue + " " + lastNameValue);

        Assert.assertEquals(labelFields.get(1).getText(),"Student Email");
        Assert.assertEquals(valuelFields.get(1).getText(),userEmailValue);

        Assert.assertEquals(labelFields.get(2).getText(),"Gender");
        Assert.assertEquals(valuelFields.get(2).getText(),"Male");

        Assert.assertEquals(labelFields.get(3).getText(),"Mobile");
        Assert.assertEquals(valuelFields.get(3).getText(),userMobileNumberValue);

        Assert.assertEquals(labelFields.get(4).getText(),"Date of Birth");
//        Assert.assertEquals(valuelFields.get(4).getText(),);

        Assert.assertEquals(labelFields.get(5).getText(),"Subjects");
        Assert.assertEquals(valuelFields.get(5).getText(),subjectValue);

        Assert.assertEquals(labelFields.get(6).getText(),"Hobbies");
        for (Integer index=0; index<Hobbies.size(); index++) {
            Assert.assertTrue(valuelFields.get(6).getText().contains(Hobbies.get(index)));
        }

        Assert.assertEquals(labelFields.get(7).getText(),"Picture");
        String[] arrayFile= filePath.split("/");
        Integer desireIndex= arrayFile.length - 1;
        Assert.assertEquals(valuelFields.get(7).getText(),arrayFile[desireIndex]);

        Assert.assertEquals(labelFields.get(8).getText(),"Address");
        Assert.assertEquals(valuelFields.get(8).getText(),currentAddressFieldValue);

        Assert.assertEquals(labelFields.get(9).getText(),"State and City");
        Assert.assertEquals(valuelFields.get(9).getText(),stateValue + " " + cityValue);




//        JavascriptExecutor scroll4 = (JavascriptExecutor) webDriver;
//        js.executeScript("window.scrollBy(0,450)", "");
//
//        WebElement closeButton= webDriver.findElement(By.id("closeLargeModal"));
//        js.executeScript("arguments[0].click();", closeButton);

    }
}