package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedinBasePage {
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

   /* public WebElement getPageAlert() {
        return driver.findElement(By.id("global-alert-queue"));
    }*/


    public void waitUntilElementIsClickable (WebElement webElement){
        waitUntilElementIsClickable(webElement, 10);
    }

    public void waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitUntilElementIsVisible (WebElement webElement){
        waitUntilElementIsVisible (webElement, 10);
    }

    public void waitUntilElementIsVisible (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }


}
