package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInLoginPage extends LinkedinBasePage {
    /**
     *Constructor of LinkedinLoginPage class that takes WebDriver instance from LinkedinBasePage class and
     *initialise LinkedinHomePage WebElements via PageFactory.
     *@param driver- WebDriver instance that was initialised LinkedinBasePage class
     */


    public LinkedInLoginPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    @FindBy(id="global-alert-queue")
    private  WebElement AlertMessage;
    @FindBy(id = "session_key-login")
    private WebElement emailField;
    @FindBy(id = "session_password-login")
    private WebElement passwordField;
    @FindBy(id = "btn-primary")
    private WebElement signInButton;
    @FindBy (id="session_key-login-error")
    private WebElement emailErrorMessage;
    @FindBy (id="session_password-login-error")
    private WebElement passwordErrorMessage;

    /**
     * verifies if alert message is displayed
     * @return true if alert message is shown and false - if not
     */
    public boolean isNotSignedIn(){
        waitUntilElementIsVisible(AlertMessage);
        return AlertMessage.isDisplayed();
    }


    /**
     * get text of the error message for email
     * @return  error's text for invalid email address
     */

    public String getEmailError(){
        waitUntilElementIsVisible(emailErrorMessage);
        String errorMessageEmail = emailErrorMessage.getText();
        return errorMessageEmail;
    }
    /**
     * get text of the error message for password
     * @return  error's text for invalid password
     */

    public String getPasswordError(){
        waitUntilElementIsVisible(passwordErrorMessage);
        String errorMessageEmail = passwordErrorMessage.getText();
        return errorMessageEmail;
    }


}
