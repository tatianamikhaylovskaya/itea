import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedinLoginPage {
    WebDriver driver;
    public LinkedinLoginPage(WebDriver driver){
        this.driver = driver;
    }

    private WebElement emailField;
    private WebElement paswordField;
    private WebElement signInButton;
    private  void initElement(){
        emailField = driver.findElement(By.xpath("//*[@id='login-email']"));
        waitUntilElementsClickable(emailField,10);
        paswordField = driver.findElement(By.xpath("//*[@id='login-password']"));
        signInButton = driver.findElement(By.id("login-submit"));
    }

    public void loginAs(String email, String password){
        initElement();
        emailField.sendKeys(email);
        paswordField.sendKeys(password);
        signInButton.click();
    }

    public void waitUntilElementsClickable (WebElement Webelement){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(Webelement));
    }

    public void waitUntilElementsClickable (WebElement Webelement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(Webelement));
    }
}
