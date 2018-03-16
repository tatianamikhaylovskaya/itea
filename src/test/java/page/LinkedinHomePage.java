package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinHomePage extends LinkedinBasePage{

    public LinkedinHomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "profile-nav-item")
    private WebElement userIcon;

    @FindBy(xpath = "//input[@placeholder='Поиск']")
    public WebElement searchField;

    @FindBy(xpath = "//*[@type='search-icon']")
    public WebElement searchIcon;

    public String searchTerm = "hr";

    public boolean isSignedIn(){
        waitUntilElementIsClickable(userIcon);
        return userIcon.isDisplayed();
    }

    public LinkedInSearchPage searchByTerm(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchIcon.click();
        return new LinkedInSearchPage(driver);


    }
}


   /* public LinkedInSearchPage searchResults() {
        waitUntilElementIsClickable(searchField, 10);
        searchField.sendKeys(searchTerm);
        waitUntilElementIsClickable(searchIcon, 10);
        searchIcon.click();
        return new LinkedInSearchPage(driver);
    }
*/
