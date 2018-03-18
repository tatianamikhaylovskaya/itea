package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInLoginPage extends LinkedinBasePage {

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

    public boolean isNotSignedIn(){
        waitUntilElementIsVisible(AlertMessage);
        return AlertMessage.isDisplayed();
    }


    public LinkedInLoginPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    public String getEmailError(){
        waitUntilElementIsVisible(emailErrorMessage);
        String errorMessageEmail = emailErrorMessage.getText();
        return errorMessageEmail;
    }

    public String getPasswordError(){
        waitUntilElementIsVisible(passwordErrorMessage);
        String errorMessageEmail = passwordErrorMessage.getText();
        return errorMessageEmail;
    }


}
