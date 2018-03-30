package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInResetPasswordSuccessPage extends LinkedinBasePage{


    @FindBy(xpath = "//div[@class= '//a[@class= 'btn-secondary-transparent']")
    private WebElement goToHomeButton;

    public LinkedInResetPasswordSuccessPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LinkedinHomePage loginWithNewPassword(String password) {
        goToHomeButton.click();
        return new LinkedinHomePage(driver);
    }
}
