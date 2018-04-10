package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

public class LinkedinChooseNewPasswordPage extends LinkedinBasePage{
    @FindBy(id = "new_password-newPassword-passwordReset")
    private WebElement newPasswordField;

    @FindBy(id = "new_password_again-newPassword-passwordReset")
    private WebElement newPasswordRetypeField;

    @FindBy(id = "reset")
    private WebElement submitButton;

    String newPassword = "qwertyQ1";

    /**
     *Constructor of LinkedinLoginPage class that takes WebDriver instance from LinkedinBasePage class and
     *initialise LinkedinHomePage WebElements via PageFactory.
     *@param driver- WebDriver instance that was initialised LinkedinBasePage class
     */
    public LinkedinChooseNewPasswordPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * verifying if the specific web page is loaded
     * @return true if page loaded and false - if not
     */
    public boolean isLoaded() {
        boolean isLoaded = false;
        try {
            isLoaded = submitButton.isDisplayed();
        }
        catch (NoSuchElementException e) {
            isLoaded = false;
        }
        return isLoaded;
    }

    /**
     * Fulfills two mandatory fields with new password and clicks on submit
     * @param newPassword - new password to be entered in both fields
     * @return next page that appears after submitting
     */
    public LinkedInResetPasswordSuccessPage resetPassword (String newPassword) {
        newPasswordField.sendKeys(newPassword);
        newPasswordRetypeField.sendKeys(newPassword);
        waitUntilElementIsClickable(submitButton).click();
        return new LinkedInResetPasswordSuccessPage(driver);
    }
}
