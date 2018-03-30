package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class LinkedinBasePage {
        WebDriver driver;

        public LinkedinBasePage(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public String getPageTitle() {
            return driver.getTitle();
        }

        public String getPageUrl(){
            return driver.getCurrentUrl();
        }


    public WebElement waitUntilElementIsClickable (WebElement webElement){

            waitUntilElementIsClickable(webElement, 10);
            return webElement;
    }

    /**
     * Wait until WebElement is Clickable on Web page
     * @param webElement - WebElement to wait for
     * @param timeOutInSeconds -
     * @return - WebElement after wait
     */
    public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    public void waitUntilElementIsVisible (WebElement webElement){
        waitUntilElementIsVisible (webElement, 10);
    }

    public void waitUntilElementIsVisible (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

}
