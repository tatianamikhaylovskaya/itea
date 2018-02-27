import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginPage extends LinkedinBasePage{
    WebDriver driver;
    public LinkedinLoginPage(WebDriver driver){
        super(driver);
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



    public LinkedinBasePage loginAs(String email, String password){
        initElement();
        emailField.sendKeys(email);
        paswordField.sendKeys(password);
        signInButton.click();
        return new LinkedinBasePage(driver);
    }


}
