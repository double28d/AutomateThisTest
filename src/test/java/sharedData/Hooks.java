package sharedData;

import loggerUtillity.LoggerUtillity;
import net.bytebuddy.implementation.bind.annotation.DefaultMethod;
import org.openqa.selenium.bidi.log.Log;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks extends SharedData {

    private String testName;

    @BeforeMethod
    public void prepareEnvironment(){
        testName = this.getClass().getSimpleName();
        LoggerUtillity.startTestCase(testName);
        prepareDriver();
        LoggerUtillity.infoTest("The driver is open with SUCCESS");

    }

    @AfterMethod
    public void clearEnvironment(ITestResult result){
        if (!result.isSuccess()){
            LoggerUtillity.errorTest(result.getThrowable().getMessage());
        }
        clearDriver();
        LoggerUtillity.infoTest("The driver is closed with SUCCESS");
        LoggerUtillity.finishTestCase(testName);
    }


}
