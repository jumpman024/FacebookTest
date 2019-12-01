package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FacebookPage;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FacebookPage {

    private WebDriver driver;

    public FacebookPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='pagelet_composer']")
    private WebElement postSection;

    @FindBy(xpath = "//div[@class='_3ixn']")
    WebElement blurElement;

    @FindBy(xpath = "//div[@class='_1mwp navigationFocus _395 _1mwq _4c_p _5bu_ _3t-3 _34nd _21mu _5yk1']")
    WebElement postWrite;

    @FindBy (xpath = "//button[@class='_1mf7 _4r1q _4jy0 _4jy3 _4jy1 _51sy selected _42ft']")
    WebElement clickButton;

    @FindBy(xpath = "div[@id='topnews_main_stream_408239535924329']")
    WebElement submittedPost;

    @FindBy(xpath = "//div[@class='_6a uiPopover _5pbi _cmw _b1e _1wbl']")
    WebElement editButton;
    //a[@class='_4xev _p']

    @FindBy(xpath = "//a[@data-testid='feed_post_edit']")
    WebElement editPostButton;

    @FindBy(xpath = "//div[@class='_1mf _1mj']")
    WebElement UpdatePost;

    @FindBy(xpath = "//button[@class='_1mf7 _4jy0 _4jy3 _4jy1 _51sy selected _42ft']")
    WebElement updatePostButton;

    @FindBy(xpath = "//a[@data-feed-option-name='FeedDeleteOption']")
    WebElement deleteButton;

    @FindBy(xpath = "//button[@class='_42ft _4jy0 layerConfirm uiOverlayButton _4jy3 _4jy1 selected _51sy']")
    WebElement postDeleteButton;



    public Boolean postSectionIsDisplayed(){
        return postSection.isDisplayed();
    }

    public FacebookPage deleteBlurScreen(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return (FacebookPage) executor.executeScript("return document.getElementsByClassName('_3ixn')[0].remove();");
    }

    public FacebookPage writeSomePost() {
        Actions actions = new Actions(driver);
        actions.doubleClick(postSection).perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actions.sendKeys("Some post").perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actions.click(clickButton).perform();
        return this;
    }

    public FacebookPage clickUpdateButton(){
        Actions actions = new Actions(driver);
        editButton.click();
        actions.moveToElement(editPostButton).click().perform();
        //UpdatePost.clear();
        UpdatePost.click();
        UpdatePost.sendKeys("Some Post Update");
        updatePostButton.click();
        return this;
    }

    public FacebookPage deleteUpdatedPost(){
        Actions actions = new Actions(driver);
        actions.doubleClick(postSection).perform();
        actions.click(clickButton).perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        editButton.click();
        actions.moveToElement(deleteButton).click().perform();
        postDeleteButton.click();
        return this;
    }


}




