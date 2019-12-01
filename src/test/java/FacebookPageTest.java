import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FacebookLoginPage;
import pages.FacebookPage;

public class FacebookPageTest extends BaseTest {

    public FacebookLoginPage facebookLoginPage;
    public FacebookPage facebookPage;

    @BeforeMethod()
    public void startup(){
        facebookLoginPage = new FacebookLoginPage(driver);
        facebookPage = new FacebookPage(driver);
    }

    @Test (description = "This test confirms user login to Facebook")
    public void testCase1(){
        facebookLoginPage.inputEmail()
                .inputPassword()
                .clickLogInButton();
        try
        {
            Thread.sleep(5000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
        facebookPage.deleteBlurScreen();
        Assert.assertTrue(facebookPage.postSectionIsDisplayed());

    }

    @Test (description = "Write some post and update it")
    public void testCase2(){
        facebookLoginPage.inputEmail()
                .inputPassword()
                .clickLogInButton();
        try
        {
            Thread.sleep(5000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
        facebookPage.deleteBlurScreen();
        facebookPage.writeSomePost();
        facebookPage.clickUpdateButton();

    }


    @Test (description = "Delete Post")
    public void testCase4(){
        facebookLoginPage.inputEmail()
                .inputPassword()
                .clickLogInButton();
        try
        {
            Thread.sleep(5000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
        facebookPage.deleteBlurScreen();
        facebookPage.deleteUpdatedPost();
    }


}
