package Tests;

import HelperMethods.ElementMethods;
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
        ElementMethods elementMethods = new ElementMethods(getWebDriver());

        //facem un scroll la pagina
        elementMethods.scrollElementByPixel(0, 450);

        //identificam un element
//        WebElement consentField = getWebDriver().findElement(By.className("fc-button-label"));
//        elementMethods.clickElement(consentField);

        WebElement elementsField = getWebDriver().findElement(By.xpath("//h5[text()='Elements']"));
        elementMethods.clickElement(elementsField);

        elementMethods.scrollElementByPixel(0, 250);

        WebElement webTablesField = getWebDriver().findElement(By.xpath("//span[text()='Web Tables']"));
        elementMethods.clickElement(webTablesField);

        WebElement addField = getWebDriver().findElement(By.id("addNewRecordButton"));
        elementMethods.clickElement(addField);

        WebElement firstnameField = getWebDriver().findElement(By.id("firstName"));
        String firstnameValue = "Gescu";
        elementMethods.fillElement(firstnameField, firstnameValue);

        WebElement lastnameField = getWebDriver().findElement(By.id("lastName"));
        String lastnameValue = "Vorbitorul";
        elementMethods.fillElement(lastnameField, lastnameValue);

        WebElement emailField = getWebDriver().findElement(By.id("userEmail"));
        String emailValue = "GSrocks@gSmnj.com";
        elementMethods.fillElement(emailField, emailValue);

        WebElement ageField = getWebDriver().findElement(By.id("age"));
        String ageValue = "30";
        elementMethods.fillElement(ageField, ageValue);

        WebElement salaryField = getWebDriver().findElement(By.id("salary"));
        String salaryValue = "500";
        elementMethods.fillElement(salaryField, salaryValue);

        WebElement departmentField = getWebDriver().findElement(By.id("department"));
        String departmentValue = "QA";
        elementMethods.fillElement(departmentField, departmentValue);


        WebElement submitField = getWebDriver().findElement(By.id("submit"));
        elementMethods.clickElement(submitField);

        //modificam entry-ul adaugat mai sus

        WebElement editField = getWebDriver().findElement(By.id("edit-record-4"));
        elementMethods.clickElement(editField);

        WebElement firstNameModifyField = getWebDriver().findElement(By.id("firstName"));
        String firstNameModifyValue = "Sorin";
        elementMethods.refillElement(firstNameModifyField, firstNameModifyValue);

        WebElement lastNameField = getWebDriver().findElement(By.id("lastName"));
        String lastNameValue = "Gutu";
        elementMethods.refillElement(lastNameField, lastNameValue);


    }
}
