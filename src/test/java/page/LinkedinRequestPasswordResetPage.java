package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

public class LinkedinRequestPasswordResetPage extends LinkedinBasePage{

    @FindBy(xpath = "//input[@name='userName']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@name='request']")
    private WebElement submitButton;
    /**
     *Constructor of LinkedinRequestPasswordResetPage class that takes WebDriver instance from LinkedinBasePage class and
     *initialise LinkedinHomePage WebElements via PageFactory.
     *@param driver- WebDriver instance that was initialised LinkedinBasePage class
     */


    public LinkedinRequestPasswordResetPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * fill email field and click submitButton for changing password process
     * @param userEmail - email address of the user to which system should send the link
     * @return the next page, Reset Submit Page
     */

    public LinkedinPasswordResetSubmitPage submitEmail(String userEmail) {
        userNameField.sendKeys(userEmail);
        submitButton.click();
        return new LinkedinPasswordResetSubmitPage(driver);
    }

    /**
     *  verifies if page is loaded, by checking the appearance of the button
     * @return true if User Name field is displayed and false - if not
     */

    public boolean isLoaded() {
        boolean isLoaded;
        try {
            isLoaded = userNameField.isDisplayed();
        }
        catch (NoSuchElementException e){
            isLoaded = false;
        }
        return isLoaded;
    }
}