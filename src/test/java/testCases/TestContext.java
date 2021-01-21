package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestContext {
    private WebDriver driver;

    final String DRIVER_PATH = "/Users/viktormacbook/Documents/Selenium/chromedriver";

    @BeforeSuite
    public void initialiseMainElements(){

    }

    @AfterSuite
    public void closeDriver(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
