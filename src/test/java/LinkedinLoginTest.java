import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.bind.Element;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    @Test
public void successfullLoginTest() throws InterruptedException {
    WebDriver driver = new FirefoxDriver();
    driver.get("https://www.linkedin.com/");
    WebElement emailField = driver.findElement(By.xpath("//*[@id='login-email']"));
    //WebElement emailField = driver.findElement(By.id("login-email"));// такаяже строка как и верхняя
    WebElement paswordField = driver.findElement(By.xpath("//*[@id='login-password']"));
    WebElement signInButton = driver.findElement(By.id("login-submit"));

    emailField.sendKeys("iteatest@i.ua");
    paswordField.sendKeys("1q2w3e_4r");
    signInButton.click();
        sleep(5000);
      //driver.getCurrentUrl();
        String expectedUrl = "https://www.linkedin.com/feed/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
       // Assert.assertEquals(driver.getCurrentUrl(), expectedUurl);
       // Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/feed/");
        WebElement messagingIcon = driver.findElement(By.xpath("//span[@id='messaging-tab-icon']"));
        Assert.assertTrue(messagingIcon.isDisplayed());
}

    @Test
    public void negativeLoginTest(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com/");
        WebElement emailField = driver.findElement(By.xpath("//*[@id='login-email']"));
        //WebElement emailField = driver.findElement(By.id("login-email"));// такаяже строка как и верхняя
        WebElement paswordField = driver.findElement(By.xpath("//*[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.id("login-submit"));

        emailField.sendKeys("iteatest@i.ua");
        paswordField.sendKeys("1q2w3e_4r");
        signInButton.click();

        WebElement alertMessage = driver.findElement(By.xpath("//div[@id='global-alert-queue']//strong[not(text()='')]"));

                Assert.assertTrue(alertMessage.isDisplayed(),"Alert message is not displayed");

    }
}
