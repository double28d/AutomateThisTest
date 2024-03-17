package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablePage extends BasePage{
    public WebTablePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy (id = "addNewRecordButton")
    private WebElement addField;
    @FindBy (id = "firstName")
    private WebElement firstNameField;
    @FindBy (id = "lastName")
    private WebElement lastNameField;
    @FindBy(id = "userEmail")
    private WebElement emailField;
    @FindBy(id = "age")
    private WebElement ageField;
    @FindBy(id = "salary")
    private WebElement salaryField;
    @FindBy(id = "department")
    private WebElement departmentField;
    @FindBy(id = "submit")
    private WebElement submitField;
    @FindBy(id = "edit-record-4")
    private WebElement editField;
    @FindBy(id = "delete-record-4")
    private WebElement deleteButton;

    public void addNewEntry (String firstNameValue, String lastNameValue, String emailValue,
                             String ageValue, String salaryValue, String departmentValue){
        elementMethods.clickElement(addField);
        elementMethods.fillElement(firstNameField, firstNameValue);
        elementMethods.fillElement(lastNameField, lastNameValue);
        elementMethods.fillElement(emailField, emailValue);
        elementMethods.fillElement(ageField, ageValue);
        elementMethods.fillElement(salaryField, salaryValue);
        elementMethods.fillElement(departmentField, departmentValue);
        elementMethods.clickElement(submitField);
    }

    public void editEntry (String firstNameValue, String lastNameValue){
        elementMethods.clickElement(editField);
        elementMethods.refillElement(firstNameField, firstNameValue);
        elementMethods.refillElement(lastNameField, lastNameValue);
        elementMethods.clickElement(submitField);
    }

    public void deleteEntry (){
        elementMethods.clickElement(deleteButton);

    }

}
