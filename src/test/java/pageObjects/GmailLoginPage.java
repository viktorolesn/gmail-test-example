package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class GmailLoginPage extends GmailHomePage {
    @FindBy(xpath="//*[@id=\"initialView\"]/div[2]")
    private WebElement loginForm;

    @FindBy(xpath="//*[@id=\"identifierId\"]")
    private WebElement usernameInput;

    @FindBy(xpath="//*[@id=\"password\"]/div[1]/div/div[1]/input")
    private WebElement passwordInput;

    @FindBy(linkText="/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/div[2]")
    private WebElement submitButton;

    public GmailLoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    //Set username in username text input
    public void setUserName(String strUserName){
        usernameInput.clear();
        usernameInput.sendKeys(strUserName);
    }

    //Set password in password text input
    public void setPassword(String strPassword){
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.clear();
        passwordInput.sendKeys(strPassword);
    }

    //Click on login button
    public void clickLogin(){
        submitButton.click();
    }

    public void loginToGmail(String strUserName, String strPassword){
        //Wait until form appears
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "2");
        wait.until(ExpectedConditions.visibilityOf(loginForm));
        //Fill user name
        this.setUserName(strUserName);
        this.clickLogin();
        //Fill password
        this.setPassword(strPassword);
        //Click Login button
        this.clickLogin();
    }
}
