package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinChooseNewPasswordPage extends LinkedinBasePage{
    @FindBy(xpath = "//input[@name= 'new_password']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//input[@name= 'new_password_again']")
    private WebElement newPasswordRetypeField;

    @FindBy(xpath = "//input[@class= 'btn-submit']")
    private WebElement submitButton;

    public LinkedinChooseNewPasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LinkedInResetPasswordSuccessPage submitNewPassword(String password) {
        newPasswordField.sendKeys(password);
        newPasswordRetypeField.sendKeys(password);
        waitUntilElementIsClickable(submitButton).click();
        return new LinkedInResetPasswordSuccessPage(driver);
    }



}
