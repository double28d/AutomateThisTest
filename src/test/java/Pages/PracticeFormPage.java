package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormPage extends BasePage {
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
    @FindBy(xpath = "//div[not(contains(@class, 'outside-month'))" +
            " and contains(@class, 'react-datepicker__day react-datepicker__day')]")
    private List<WebElement> dayPick;
    @FindBy(id = "subjectsInput")
    private WebElement subjectsField;
    @FindBy(xpath = "//div[@id='hobbiesWrapper']//label[@class='custom-control-label']")
    private List<WebElement> hobbiesList;
    @FindBy(id = "uploadPicture")
    private WebElement pictureField;
    @FindBy(css = "textarea[placeholder='Current Address']")
    private WebElement currentAddressField;
    @FindBy(xpath = "//div[text()='Select State']")
    private WebElement selectState;
    @FindBy(id = "react-select-3-input")
    private WebElement stateInputField;
    @FindBy(xpath = "//div[text()='Select City']")
    private WebElement selectCity;
    @FindBy(id = "react-select-4-input")
    private WebElement cityInputField;
    @FindBy(id = "submit")
    private WebElement submitButton;
    @FindBy(xpath = "//table/tbody/tr/td[1]")
    private List<WebElement> labelFields;
    @FindBy(xpath = "//table/tbody/tr/td[2]")
    private List<WebElement> valuelFields;

    public void fillFirstName(String firstnameValue) {
        elementMethods.fillElement(firstNameField, firstnameValue);
        elementMethods.scrollElementByPixel(0, 250);
    }

    public void fillLastName(String lastNameValue) {
        elementMethods.fillElement(lastNameField, lastNameValue);
    }

    public void fillUserEmail(String userEmailValue) {
        elementMethods.fillElement(userEmailField, userEmailValue);
    }

    public void fillMobileNumber(String userMobileNumberValue) {
        elementMethods.fillElement(mobileNumberField, userMobileNumberValue);
    }

    public void fillBirthDay(String monthValue, String yearValue, String dayValue) {
        elementMethods.clickElement(dateOfBirthField);
        elementMethods.selectTextElement(monthPick, monthValue);
        elementMethods.selectValueElement(yearPick, yearValue);

        for (Integer index = 0; index < dayPick.size(); index++) {
            if (dayPick.get(index).getText().equals(dayValue)) {
                dayPick.get(index).click();
                break;
            }
        }
    }

    public void pickGender(String genderValue) {
        userGenderField.click();
    }

    public void pickHobbies(List<String> hobbies) {
        for (Integer index = 0; index < hobbiesList.size(); index++) {
            String currentElementText = hobbiesList.get(index).getText();
            if (hobbies.contains(currentElementText)) {
                elementMethods.clickElemForce(hobbiesList.get(index));
            }
        }
    }

    public void pickSubject(String subjectValue) {
        elementMethods.fillPressElement(subjectsField, subjectValue, Keys.ENTER);
    }

    public void pickPicture(String filePath) {
        elementMethods.fillElement(pictureField, new File(filePath).getAbsolutePath());
    }

    public void setCurrentAddressField(String currentAddressFieldValue) {
        elementMethods.scrollElementByPixel(0, 450);
        elementMethods.fillElement(currentAddressField, currentAddressFieldValue);
    }

    public void pickState(String stateValue) {
        elementMethods.clickElemForce(selectState);
        elementMethods.fillPressElement(stateInputField, stateValue, Keys.ENTER);
        elementMethods.scrollElementByPixel(0, 450);
    }

    public void pickCity(String cityValue) {
        elementMethods.scrollElementByPixel(0, 650);
        elementMethods.waitVisibleElement(selectCity);
        elementMethods.clickElemForce(selectCity);
        elementMethods.fillPressElement(cityInputField, cityValue, Keys.ENTER);
    }

    public void clickSubmit() {
        elementMethods.clickElemForce(submitButton);

    }

    public void validatePracticeFormTable(String firstnameValue, String lastNameValue, String userEmailValue, String genderValue,
                                          String userMobileNumberValue, String subjectValue, List<String> hobbies, String filePath,
                                          String currentAddressFieldValue, String stateValue, String cityValue) {
//
        Assert.assertEquals(labelFields.get(0).getText(),"Student Name");
        Assert.assertEquals(valuelFields.get(0).getText(),firstnameValue + " " + lastNameValue);

        Assert.assertEquals(labelFields.get(1).getText(),"Student Email");
        Assert.assertEquals(valuelFields.get(1).getText(),userEmailValue);

        Assert.assertEquals(labelFields.get(2).getText(),"Gender");
        Assert.assertEquals(valuelFields.get(2).getText(), "Male");

        Assert.assertEquals(labelFields.get(3).getText(),"Mobile");
        Assert.assertEquals(valuelFields.get(3).getText(),userMobileNumberValue);

        Assert.assertEquals(labelFields.get(4).getText(),"Date of Birth");
//        Assert.assertEquals(valuelFields.get(4).getText(),d);

        Assert.assertEquals(labelFields.get(5).getText(),"Subjects");
        Assert.assertEquals(valuelFields.get(5).getText(),subjectValue);

        Assert.assertEquals(labelFields.get(6).getText(),"Hobbies");
        for (Integer index = 0; index < hobbies.size(); index++) {
            Assert.assertTrue(valuelFields.get(6).getText().contains(hobbies.get(index)));
        }

        Assert.assertEquals(labelFields.get(7).getText(),"Picture");
        String[] arrayFile= filePath.split("/");
        Integer desireIndex= arrayFile.length - 1;
        Assert.assertEquals(valuelFields.get(7).getText(),arrayFile[desireIndex]);

        Assert.assertEquals(labelFields.get(8).getText(),"Address");
        Assert.assertEquals(valuelFields.get(8).getText(),currentAddressFieldValue);

        Assert.assertEquals(labelFields.get(9).getText(),"State and City");
        Assert.assertEquals(valuelFields.get(9).getText(),stateValue + " " + cityValue);

    }

    public void fillEntireForm(String firstnameValue, String lastNameValue, String userEmailValue, String userMobileNumberValue,
                               String monthValue, String yearValue, String dayValue, String genderValue, List<String> hobbies,
                               String subjectValue, String filePath, String currentAddressFieldValue, String stateValue,
                               String cityValue){
        fillFirstName(firstnameValue);
        fillLastName(lastNameValue);
        fillUserEmail(userEmailValue);
        fillMobileNumber(userMobileNumberValue);
        fillBirthDay(monthValue,yearValue,dayValue);
        pickGender(genderValue);
        pickHobbies(hobbies);
        pickSubject(subjectValue);
        pickPicture(filePath);
        setCurrentAddressField(currentAddressFieldValue);
        pickState(stateValue);
        pickCity(cityValue);
        clickSubmit();
    }

}

