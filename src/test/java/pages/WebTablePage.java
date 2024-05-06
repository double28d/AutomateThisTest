package pages;

import objectData.WebTableObject;
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

    public void addNewEntry (WebTableObject webTableObject){
        elementMethods.clickElement(addField);
        elementMethods.fillElement(firstNameField, webTableObject.getFirstnameValue());
        elementMethods.fillElement(lastNameField, webTableObject.getLastnameValue());
        elementMethods.fillElement(emailField, webTableObject.getEmailValue());
        elementMethods.fillElement(ageField, webTableObject.getAgeValue());
        elementMethods.fillElement(salaryField, webTableObject.getSalaryValue());
        elementMethods.fillElement(departmentField, webTableObject.getDepartmentVal());
        elementMethods.clickElement(submitField);
    }

    public void editEntry (WebTableObject webTableObject){
        elementMethods.clickElement(editField);
        elementMethods.refillElement(firstNameField, webTableObject.getFirstNameModi());
        elementMethods.refillElement(lastNameField, webTableObject.getLastNameModif());
        elementMethods.clickElement(submitField);
    }

    public void deleteEntry (){
        elementMethods.clickElement(deleteButton);

    }

}
