import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.Thread.sleep;

public class LinkedinSearchTest {
    WebDriver driver;

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
    public void basicSearchTest() {
        LinkedinLoginPage loginPage = new LinkedinLoginPage(driver);
        loginPage.loginAs("taraschudnyy@gmail.com", "Xelyfz!6");


        //search
       // WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Search']));
        //WebElement searchButton = driver.findElement(By.id("nav-search-controls-wormhole"));
        //searchField.sendKeys("hr");
        //searchButton.click();
    }



}
