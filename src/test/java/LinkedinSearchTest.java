import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class LinkedinSearchTest {
    WebDriver driver;

    @BeforeMethod
    public  void beforeTest(){
        driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); лучше не использовать
        driver.get("https://www.linkedin.com/");
    }
    @AfterMethod
    public void afterTest(){
        driver.close();
    }

    @Test
    public void basicSearchTest() throws InterruptedException {
        LinkedinLoginPage loginPage = new LinkedinLoginPage(driver);
        loginPage.loginAs("taraschudnyy@gmail.com", "Xelyfz!6");


        String searchTerm = "HR";
        WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Поиск']"));
        WebElement searchButton = driver.findElement(By.xpath("//*[@type='search-icon']"));
        searchField.sendKeys(searchTerm);
        searchButton.click();


        List<WebElement> results = driver.findElements(By.xpath("//ul[@class='search-results__list list-style-none']/li[contains(@class,'search-result__occluded-item')]"));
        int currentResultNumber = results.size();
        Assert.assertEquals(results.size(),10,"Number of results is Wrong");

        for (int i=1; i < results.size();i++) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",results.get(i));
            String cardTitle = driver.findElement(By.xpath("//li[contains(@class,'search-result__occluded-item')]["+i+"]//span[contains(@class,'name actor-name')]")).toString();
            Assert.assertTrue(cardTitle.contains(searchTerm.toLowerCase()),"searchTerm  "+searchTerm+" not found in cart" + Integer.toString(i));
             System.out.println(cardTitle);
           // WebElement cardTitle = driver.findElement(By.xpath("//ul[@class='search-results__list list-style-none']/li[contains(@class,'search-result__occluded-item')]"));
           // System.out.println(cardTitle.getText());
           // System.out.println(result.getAttribute("class"));
            }
            List<WebElement> cardTitles = driver.findElements(By.xpath("//ul[@class='search-results__list list-style-none']/li[contains(@class,'search-result__occluded-item')]//span[contains(@class,'name actor-name')]"));
            for (WebElement cardTitle: cardTitles){
                cardTitle.getText();
                System.out.println(cardTitle.getText());
            }

           // WebElement webElement = driver.findElement(By.xpath("bla-bla"));
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",webElement);





     /*   List<WebElement> searchResults = driver.findElements(By.xpath("/ul/li/div/div/div/p[@class='subline-level-1 Sans-15px-black-85% search-result__truncate']"));
        //List<WebElement> searchResults = driver.findElements(By.xpath("//div[contains(@class, 'search-result__info pt3 pb4 ph0')]"));
        for (WebElement element : searchResults) {
            String title = element.getText().toLowerCase();
            Assert.assertTrue(title.contains("hr"),"Not all results contain related to HR");
        }
        List<WebElement> elements = driver.findElements(By.xpath("//ul/li/div/div/div/p[@class='subline-level-1 Sans-15px-black-85% search-result__truncate']"));
        Assert.assertTrue(elements.size()==4,"Number of links less then 10"); */


        //List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class, 'search-result__info pt3 pb4 ph0')]"));
        //Assert.assertTrue(elements.size()==4,"Number of links less then 10");

        ////li[@class='search-result search-result__occluded-item ember-view']//*[contains(text(), 'HR')]
      //span[@class='name actor-name']//*[contains(text(), 'HR')]

       // List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class, 'search-result__wrapper')]"));
        //Assert.assertTrue(elements.size()==4);

       // List<WebElement> elements = driver.findElements(By.xpath("//li[@class='search-result search-result__occluded-item ember-view']"));
        //Assert.assertTrue(elements.size()==4);
        //div[@class='search-result__wrapper' and contains(text(), 'hr')]

    }

}
