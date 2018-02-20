import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginPage {
    WebDriver driver;
    public LinkedinLoginPage(WebDriver driver){
        this.driver = driver;
    }

    private WebElement emailField;
    private WebElement paswordField;
    private WebElement signInButton;
    private  void ininElement(){
        emailField = driver.findElement(By.xpath("//*[@id='login-email']"));
        paswordField = driver.findElement(By.xpath("//*[@id='login-password']"));
        signInButton = driver.findElement(By.id("login-submit"));
    }

    public void loginAs(String email, String password){
        ininElement();
        emailField.sendKeys(email);
        paswordField.sendKeys(password);
        signInButton.click();
    }
}
