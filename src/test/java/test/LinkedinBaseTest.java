package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.LinkedInSearchPage;
import page.LinkedinHomePage;
import page.LinkedinLandingPage;

public class LinkedinBaseTest {

    WebDriver driver;
    LinkedinHomePage homePage;
    LinkedinLandingPage landingPage;
    LinkedInSearchPage searchPage;


    @Parameters({"browserType", "urlType"})
    @BeforeMethod
    public void beforeTest(@Optional("firefox") String browserType, @Optional("https://www.linkedin.com/") String urlType) {

        switch (browserType.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                System.out.println("Unsupported browser");
        }


        driver.get(urlType);
        landingPage = new LinkedinLandingPage(driver);

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
    }

}
