
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;

import static java.lang.Thread.sleep;

public class BadCodeExample {

    public static void main(String args[]) throws InterruptedException {
            System.out.println("hello world");
            WebDriver driver = new FirefoxDriver();
            driver.get("https://www.google.com/");
            driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
            driver.findElement(By.name("btnK")).click();
            sleep(5000);


            List<WebElement>elements = driver.findElements(By.partialLinkText("eleniun"));
           // Assert.assertTrue(elements.size()==10);



            //List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"rso\"]/div/div/div/div/div/h3/a"));
            //System.out.println("Number of links: "+ list.size());
            //List<WebElement> seleniumList = driver.findElements(By.xpath("//*[@id=\"rso\"]/div/div/div/div/div/h3/a[contains(text(),'elenium')]"));
           // System.out.println("Number of Selenium links: "+ seleniumList.size());
           // if(list.size() == seleniumList.size()){
                    //System.out.println("All search results correct ");
           // } else {
                  //  System.out.println("doesn't contain word Selenium");
          //  }
           // driver.close();

}

}
