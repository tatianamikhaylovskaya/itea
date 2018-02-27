import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.xml.bind.Element;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    WebDriver driver;
    @BeforeClass
    public  void beforeClass(){

    }

   @AfterClass
    public void afterClass(){

    }

    @BeforeMethod
    public  void beforeTest(){
        driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com/");
    }
    @AfterMethod
    public void afterTest(){
        driver.close();
    }


    @Test
    public void successfullLoginTest() throws InterruptedException {


        LinkedinLoginPage loginPage = new LinkedinLoginPage(driver);


    String initialPageTitle = loginPage.getPageTitle();
    String initialPageURL = loginPage.getPageUrl();

    Assert.assertEquals(initialPageTitle, "LinkedIn: Log In or Sign Up", "login page title is wrong");

    LinkedinBasePage homePage = loginPage.loginAs("taraschudnyy@gmail.com", "Xelyfz!6");

    Assert.assertTrue(homePage.isSignedIn(), "User is not signed in");

    Assert.assertNotEquals(homePage.getPageTitle(), initialPageTitle, "Page title did not change after login");
        //Assert.assertTrue(driver.getTitle().equals(initialPageTitle), "Page title did not change after login");
    Assert.assertNotEquals(homePage.getPageUrl(), initialPageURL, "Page URL did not change after login");




   /* WebElement emailField = driver.findElement(By.xpath("//*[@id='login-email']"));
    //WebElement emailField = driver.findElement(By.id("login-email"));// такаяже строка как и верхняя
    WebElement paswordField = driver.findElement(By.xpath("//*[@id='login-password']"));
    WebElement signInButton = driver.findElement(By.id("login-submit"));


    emailField.sendKeys("taraschudnyy@gmail.com");
    paswordField.sendKeys("Xelyfz!6");
    signInButton.click();
    sleep(5000);
        WebElement userIcon = driver.findElement(By.id("profile-nav-item"));*/
 // Assert.assertTrue(userIcon.isDisplayed(), "user icon was not displayed");


/*
        //sleep(5000);
      //driver.getCurrentUrl();
       // String expectedUrl = "https://www.linkedin.com/feed/";
      // String actualUrl = driver.getCurrentUrl();
       // Assert.assertEquals(actualUrl, expectedUrl);
       // Assert.assertEquals(driver.getCurrentUrl(), expectedUurl);
       // Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/feed/");
       // WebElement messagingIcon = driver.findElement(By.xpath("//span[@id='messaging-tab-icon']"));
       // Assert.assertTrue(messagingIcon.isDisplayed());
       */
}

    @Test
    public void negativeLoginTest(){

        driver.get("https://www.linkedin.com/");
        WebElement emailField = driver.findElement(By.xpath("//*[@id='login-email']"));
        //WebElement emailField = driver.findElement(By.id("login-email"));// такаяже строка как и верхняя
        WebElement paswordField = driver.findElement(By.xpath("//*[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.id("login-submit"));

        emailField.sendKeys("iteatest@i.ua");
        paswordField.sendKeys("4444444");
        signInButton.click();

        WebElement alertMessage = driver.findElement(By.xpath("//div[@id='global-alert-queue']//strong[not(text()='')]"));

        Assert.assertTrue(alertMessage.isDisplayed(),"Alert message is not displayed");

        }
        }
