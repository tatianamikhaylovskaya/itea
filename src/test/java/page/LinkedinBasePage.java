package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public abstract class LinkedinBasePage {
        WebDriver driver;

    /**
     *Constructor of LinkedinBasePage class which takesWebDriver instance initialised in @beforeMethod
     *for reuse in LinkedinBasePage class methods
     *@param driver - webDriver instance
     */

        public LinkedinBasePage(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

    /**
     * Get page title for opened Web Page
     * @return Title for the currently opened Web Page
     */


    public String getPageTitle() {
            return driver.getTitle();
        }

    /**
     *Get page URL for opened Web Page
     * @return URL for the currently opened Web Page
     */

        public String getPageUrl(){
            return driver.getCurrentUrl();
        }

    /**
     * Wait until WebElement is Clickable on Web page for a given time interval
     * @param webElement - WebElement to wait for
     * @return - WebElement after wait
     */


    public WebElement waitUntilElementIsClickable (WebElement webElement){

            waitUntilElementIsClickable(webElement, 10);
            return webElement;
    }

    /**
     * Wait until WebElement is Clickable on Web page
     * @param webElement - WebElement to wait for
     * @param timeOutInSeconds - The time that the system will wait for the  WebElement
     * @return - WebElement after wait
     */
    public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    /**
     * Wait until WebElement appears on the Web Page for a given time interval
     * @param webElement - Web Element to Wait for
     */

    public void waitUntilElementIsVisible (WebElement webElement){
        waitUntilElementIsVisible (webElement, 10);
    }
    /**
     * Wait until WebElement appears on the Web Page
     * @param webElement - Web Element to Wait for
     * @param timeOutInSeconds -The time that the system will wait for the appearance of WebElement
     */


    public void waitUntilElementIsVisible (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

}
