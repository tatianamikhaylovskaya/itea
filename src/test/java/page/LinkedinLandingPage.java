package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLandingPage extends LinkedinBasePage {

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


