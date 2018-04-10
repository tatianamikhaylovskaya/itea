package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLandingPage extends LinkedinBasePage {
    /**
     *Constructor of LinkedinLandingPage class that takes WebDriver instance from LinkedinBasePage class and
     *initialise LinkedinHomePage WebElements via PageFactory.
     *@param driver- WebDriver instance that was initialised LinkedinBasePage class
     */
    public LinkedinLandingPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "login-email")
    private WebElement emailField;
    @FindBy (id = "login-password")
    private WebElement passwordField;
    @FindBy (id = "login-submit")
    private WebElement signInButton;
    @FindBy (xpath="//a[@class='link-forgote-password']")
    private WebElement forgotPasswordLink;

    /**
     * Start reset password process by clicking Forgot password link
     * @return  page to start changing password flow
     */

    public LinkedinRequestPasswordResetPage forgotPasswordLinkClick ()
    { forgotPasswordLink.click();
    return  new LinkedinRequestPasswordResetPage(driver);

    }

    /**
     * Login to the system by entering email and password and clicking on signIn Button;
     * @param email - email is used for login
     * @param password - password is used for login
     * @param <T> - type of the used parameters, that returns appropriate page object
     * @return  new page depends on used params
     */
    public <T> T loginAs(String email, String password) {
        waitUntilElementIsClickable(emailField, 5);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        if (getPageUrl().contains("/feed")) {
            return (T) new LinkedinHomePage(driver);
               }
        if (getPageUrl().contains("/login-submit")) {
            return (T) new LinkedInLoginPage(driver);
        }
        else
            {
            return (T) this;
        }

}
}

 /* public LinkedinHomePage loginAs(String email, String password){
        waitUntilElementIsClickable(emailField, 10);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(driver, LinkedinHomePage.class);
    }

    public LinkedinLandingPage loginAs(String email){
        loginAs(email, "555555");
        return new LinkedinLandingPage(driver);
    }*/


