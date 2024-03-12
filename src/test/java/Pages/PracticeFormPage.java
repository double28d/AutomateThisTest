package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormPage extends BasePage{
    public PracticeFormPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "firstName")
    private WebElement firstNameField;
    @FindBy(css = "input[placeholder='Last Name']")
    private WebElement lastNameField;
    @FindBy(id = "userEmail")
    private WebElement userEmailField;
    @FindBy(css = "label[for='gender-radio-1']")
    private WebElement userGenderField;
    @FindBy(css = "input[placeholder='Mobile Number']")
    private WebElement mobileNumberField;
    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthField;
    @FindBy(css = ".react-datepicker__month-select")
    private WebElement monthPick;
    @FindBy(css = ".react-datepicker__year-select")
    private WebElement yearPick;
    @FindBy(xpath = "//div[not(contains(@class, " +
            "'react-datepicker__day--outside-month')) "
            + "and contains (@class, 'react-datepicker__day react-datepicker__day')]")
    private List<WebElement> dayPick;
    @FindBy(id = "subjectsInput")
    private WebElement subjectsField;
    @FindBy(xpath = "//div[@id='hobbiesWrapper']//label[@class='custom-control-label']")
    private List<WebElement> hobbiesList;
    @FindBy(id = "uploadPicture")
    private WebElement pictureField;
    @FindBy(css = "textarea[placeholder='Current Address']")
    private WebElement currentAddressField;
    @FindBy(id = "react-select-3-input")
    private WebElement stateField;
    @FindBy(id = "react-select-4-input")
    private WebElement cityInputField;
    @FindBy(id = "submit")
    private WebElement submitButton;
    @FindBy(xpath = "//table/tbody/tr/td[1]")
    private List<WebElement> labelFields;
    @FindBy(xpath = "//table/tbody/tr/td[2]")
    private List<WebElement> valuelFields;

    public void fillFirstName(String firstnameValue){
        elementMethods.fillElement(firstNameField,firstnameValue);
        elementMethods.scrollElementByPixel(0,250);
    }
    public void fillLastName(String lastNameValue){
        elementMethods.fillElement(lastNameField,lastNameValue);
    }
    public void fillUserEmail(String userEmailValue){
        elementMethods.fillElement(userEmailField,userEmailValue);
    }
    public void fillMobileNumber(String userMobileNumberValue){
        elementMethods.fillElement(mobileNumberField,userMobileNumberValue);
    }
    public void fillBirthDay(String monthValue, String yearValue, String dayValue){
        elementMethods.clickElement(dateOfBirthField);
        elementMethods.selectTextElement(monthPick, monthValue);
        elementMethods.selectValueElement(yearPick,yearValue);
        for (Integer index = 0; index < dayPick.size(); index++){
            if (dayPick.get(index).getText().equals(dayValue)){
                dayPick.get(index).click();
                break;
            }
        }
    }
    public void pickGender (String genderValue){
        userGenderField.click();
    }
    public void pickHobbies (List<String> hobbies){
        for (Integer index = 0; index < hobbiesList.size(); index++){
            String currentElementText = hobbiesList.get(index).getText();
            if (hobbies.contains(currentElementText)){
                elementMethods.clickElemForce(hobbiesList.get(index));
            }
        }
    }
    public void pickSubject (String subjectValue){
        elementMethods.fillPressElement(subjectsField,subjectValue, Keys.ENTER);
    }
    public void pickPicture (String filePath){
        elementMethods.fillElement(pictureField, new File(filePath).getAbsolutePath());
    }
    public void setCurrentAddressField (String currentAddressFieldValue){
        elementMethods.fillElement(currentAddressField,currentAddressFieldValue);
    }

}

