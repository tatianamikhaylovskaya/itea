package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedInSearchPage;
import page.LinkedinHomePage;
import page.LinkedinLandingPage;

import java.util.List;

import static java.lang.Thread.sleep;

public class LinkedinSearchTest extends LinkedinBaseTest{

    /**
     * Test that verifies basic Search by Specific Search term
     */
    @Test
    public void basicSearchTest() {
        String searchTerm = "hr";
        LinkedinLandingPage loginPage = new LinkedinLandingPage(driver);
        LinkedinHomePage homePage = loginPage.loginAs("taraschudnyy@gmail.com", "Xelyfz!6");
        LinkedInSearchPage searchPage = homePage.searchByTerm (searchTerm);
        List<String> results = searchPage.getResults();

        Assert.assertEquals(results.size(),10,"Number of results is Wrong");

         for (String result: results) {
             Assert.assertTrue(result.toLowerCase().contains(searchTerm),
                     "searchTerm  \"+searchTerm+\" not found in cart");
         }



        /*for (int i=0; i < results.size();i++) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",results.get(i));
            String cardTitle = driver.findElement(By.xpath("//li[contains(@class,'search-result__occluded-item')]["+(i+1)+"]//p[contains(@class,'subline-level-1')]")).getText().toLowerCase();
            Assert.assertTrue(cardTitle.contains(searchTerm.toLowerCase()),"searchTerm  "+searchTerm+" not found in cart" + Integer.toString(i));
             System.out.println(cardTitle);
           // WebElement cardTitle = driver.findElement(By.xpath("//ul[@class='search-results__list list-style-none']/li[contains(@class,'search-result__occluded-item')]"));
           // System.out.println(cardTitle.getText());
           // System.out.println(result.getAttribute("class"));
            }
           /* List<WebElement> cardTitles = driver.findElements(By.xpath("//ul[@class='search-results__list list-style-none']/li[contains(@class,'search-result__occluded-item')]//span[contains(@class,'name actor-name')]"));
            for (WebElement cardTitle: cardTitles){
                cardTitle.getText();
                System.out.println(cardTitle.getText());
            }*/

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
