package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinHomePage extends LinkedinBasePage{

    /**
     *Constructor of LinkedinHomePage class that takes WebDriver instance from LinkedinBasePage class and
     *initialise LinkedinHomePage WebElements via PageFactory.
     *@param driver- WebDriver instance that was initialised LinkedinBasePage class
     */

    public LinkedinHomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     *
     */
    @FindBy(id = "profile-nav-item")
    private WebElement userIcon;

    @FindBy(xpath = "//input[@placeholder='Поиск']")
    public WebElement searchField;

    @FindBy(xpath = "//*[@type='search-icon']")
    public WebElement searchIcon;

    public String searchTerm = "hr";

    /**
     * check if user successfully logged in successfully by checking appearence of the User Icon  Web Element
     * @return true if User Icon appears on the web page
     */

    public boolean isSignedIn(){
        waitUntilElementIsClickable(userIcon);
        return userIcon.isDisplayed();
    }

    /**
     * Search data for entered specific search term
     * @param searchTerm - searching text
     * @return page with search results
     */

    public LinkedInSearchPage searchByTerm(String searchTerm) {
        waitUntilElementIsClickable(searchField);
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
