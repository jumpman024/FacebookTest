package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FacebookPage;

public class FacebookLoginPage {

    private WebDriver driver;

    public FacebookLoginPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//input[@type='email']")
    WebElement email;

    @FindBy (xpath = "//input[@type='password']")
    WebElement password;

    @FindBy (xpath = "//input[@value='Log In']")
    WebElement logInButton;


    public FacebookLoginPage inputEmail(){
        email.sendKeys("wmdhtyuxaw_1574956559@tfbnw.net");
        return this;
    }

    public FacebookLoginPage inputPassword(){
        password.sendKeys("Test12345!");
        return this;
    }

    public FacebookLoginPage clickLogInButton(){
        logInButton.click();
        return this;
    }
}
