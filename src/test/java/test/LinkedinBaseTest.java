package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LinkedInSearchPage;
import page.LinkedinHomePage;
import page.LinkedinLandingPage;

public class LinkedinBaseTest {

    WebDriver driver;
    LinkedinHomePage homePage;
    LinkedinLandingPage landingPage;
    LinkedInSearchPage searchPage;

    @BeforeMethod
    public  void beforeTest(){
        driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com/");
        landingPage = new LinkedinLandingPage(driver);

    }

    @AfterMethod
    public void afterTest(){
        driver.close();
    }

}
