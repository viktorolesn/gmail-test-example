package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class GmailHomePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    @FindBy(xpath="//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a")
    private WebElement gmailLink;

    @FindBy(xpath="/html/body/div[2]/div[1]/div[4]/ul[1]/li[2]/a")
    private WebElement signInButton;


    public GmailHomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    //Click Sign In Button on Home Page
    public void clickSignInButton(){
        wait.until(ExpectedConditions.visibilityOf(gmailLink));
        this.gmailLink.click();
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        this.signInButton.click();
    }

}
