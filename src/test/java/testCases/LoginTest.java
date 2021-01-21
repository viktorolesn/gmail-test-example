package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.GmailHomePage;
import pageObjects.GmailLoginPage;

import java.util.ArrayList;

public class LoginTest{
    private WebDriver driver;
    final String DRIVER_PATH = "/Users/viktormacbook/Documents/Selenium/chromedriver";
    final String WEB_URL = "http://google.com";
    String username = "test1229test1229";
    String password = "test123test123";
    private GmailHomePage objHomePage;
    private GmailLoginPage objLoginPage;

    public LoginTest(){
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
    }

    @BeforeTest
    public void initialiseMainElements(){
        driver = new ChromeDriver();
        objHomePage = new GmailHomePage(driver);
        objLoginPage = new GmailLoginPage(driver);
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }

    @Test
    public void navigateAndLogin() throws InterruptedException {
        driver.get(WEB_URL);
        objHomePage.clickSignInButton();
        objLoginPage.loginToGmail(username, password);
    }

}
