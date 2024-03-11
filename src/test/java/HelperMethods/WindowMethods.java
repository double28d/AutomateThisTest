package HelperMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowMethods {
    private WebDriver webDriver;

    public WindowMethods(WebDriver webDriver) {

        this.webDriver = webDriver;
    }
    public void switchSpecificTabWindow (Integer index){
        //identificam numarul de tab-uri deschise
        List<String> tabsOpened= new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabsOpened.get(index));
        System.out.println("Tabul Curent are URL-ul " + webDriver.getCurrentUrl());

    }

    public void closeCurrentTabWindow (){
        webDriver.close();
    }


}
