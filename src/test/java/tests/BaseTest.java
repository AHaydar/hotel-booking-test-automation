package test.java.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import test.java.utilities.Screenshot;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;

    public BaseTest(){
        driver = new FirefoxDriver();
    }

    @BeforeClass(description = "Class Level Setup!")
    public void setup () {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass(description = "Class Level Teardown!")
    public void teardown () {

        driver.quit();
    }

    @AfterMethod(description = "Run after each test method")
    public void afterScenario(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            Screenshot.captureScreenshot(driver);
        }
    }

}
