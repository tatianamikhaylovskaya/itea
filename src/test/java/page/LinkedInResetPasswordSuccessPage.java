package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

public class LinkedInResetPasswordSuccessPage extends LinkedinBasePage{


    @FindBy(xpath = "//div[@class= '//a[@class= 'btn-secondary-transparent']")
    private WebElement goToHomeButton;

    /**
     *Constructor of LinkedInResetPasswordSuccessPage class that takes WebDriver instance from LinkedinBasePage class and
     *initialise LinkedinHomePage WebElements via PageFactory.
     *@param driver- WebDriver instance that was initialised LinkedinBasePage class
     */

    public LinkedInResetPasswordSuccessPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Click on the button to the Home page
     * @return user to the Home page
     */

    public LinkedinHomePage loginWithNewPassword(String password) {
        goToHomeButton.click();
        return new LinkedinHomePage(driver);
    }

    /**
     * verify that page is loaded and Button from this page is shown
     * @return true is the button that leads to the Home page appears
     */
    public boolean isLoaded() {
        boolean isLoaded = false;
        try {
            isLoaded = goToHomeButton.isDisplayed();
        }
        catch (NoSuchElementException e) {
            isLoaded = false;
        }
        return isLoaded;
    }
}
