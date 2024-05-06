package pages;

import objectData.PracticeFormObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
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
        elementMethods.scrollElementByPixel(0, 450);
    }

    public void fillLastName(String lastNameValue) {
        elementMethods.fillElement(lastNameField, lastNameValue);
        elementMethods.scrollElementByPixel(0, 450);
    }

    public void fillUserEmail(String userEmailValue) {
        elementMethods.fillElement(userEmailField, userEmailValue);
        elementMethods.scrollElementByPixel(0, 450);
    }

    public void fillMobileNumber(String userMobileNumberValue) {
        elementMethods.fillElement(mobileNumberField, userMobileNumberValue);
        elementMethods.scrollElementByPixel(0, 450);
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
        elementMethods.waitVisibleElement(subjectsField);
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
        elementMethods.waitVisibleElement(selectCity);
        elementMethods.clickElemForce(selectCity);
        elementMethods.fillPressElement(cityInputField, cityValue, Keys.ENTER);
    }

    public void clickSubmit() {
        elementMethods.clickElemForce(submitButton);

    }

    public void validatePracticeFormTable(PracticeFormObject practiceFormObject) {

        Assert.assertEquals(labelFields.get(0).getText(),"Student Name");
        Assert.assertEquals(valuelFields.get(0).getText(),practiceFormObject.getFirstNameValue() + " " + practiceFormObject.getLastNameValue());

        Assert.assertEquals(labelFields.get(1).getText(),"Student Email");
        Assert.assertEquals(valuelFields.get(1).getText(),practiceFormObject.getUserEmailValue());

        Assert.assertEquals(labelFields.get(2).getText(),"Gender");
        Assert.assertEquals(valuelFields.get(2).getText(),practiceFormObject.getGenderValue());

        Assert.assertEquals(labelFields.get(3).getText(),"Mobile");
        Assert.assertEquals(valuelFields.get(3).getText(),practiceFormObject.getUserMobileNumberValue());

        Assert.assertEquals(labelFields.get(4).getText(),"Date of Birth");
//        Assert.assertEquals(valuelFields.get(4).getText(),d);

        Assert.assertEquals(labelFields.get(5).getText(),"Subjects");
        Assert.assertEquals(valuelFields.get(5).getText(),practiceFormObject.getSubjectValue());

        Assert.assertEquals(labelFields.get(6).getText(),"Hobbies");
        for (Integer index = 0; index < practiceFormObject.getHobbies().size(); index++) {
            Assert.assertTrue(valuelFields.get(6).getText().contains(practiceFormObject.getHobbies().get(index)));
        }

        Assert.assertEquals(labelFields.get(7).getText(),"Picture");
        String[] arrayFile= practiceFormObject.getFilePath().split("/");
        Integer desireIndex= arrayFile.length - 1;
        Assert.assertEquals(valuelFields.get(7).getText(),arrayFile[desireIndex]);

        Assert.assertEquals(labelFields.get(8).getText(),"Address");
        Assert.assertEquals(valuelFields.get(8).getText(),practiceFormObject.getCurrentAddressFieldValue());

        Assert.assertEquals(labelFields.get(9).getText(),"State and City");
        Assert.assertEquals(valuelFields.get(9).getText(),practiceFormObject.getStateValue() + " " + practiceFormObject.getCityValue());

    }

    public void fillEntireForm(PracticeFormObject practiceFormObject){
        fillFirstName(practiceFormObject.getFirstNameValue());
        fillLastName(practiceFormObject.getLastNameValue());
        fillUserEmail(practiceFormObject.getUserEmailValue());
        fillMobileNumber(practiceFormObject.getUserMobileNumberValue());
        fillBirthDay(practiceFormObject.getMonthValue(), practiceFormObject.getYearValue(), practiceFormObject.getDayValue());
        pickGender(practiceFormObject.getGenderValue());
        pickHobbies(practiceFormObject.getHobbies());
        pickSubject(practiceFormObject.getSubjectValue());
        pickPicture(practiceFormObject.getFilePath());
        setCurrentAddressField(practiceFormObject.getCurrentAddressFieldValue());
        pickState(practiceFormObject.getStateValue());
        pickCity(practiceFormObject.getCityValue());
        clickSubmit();
    }

}

