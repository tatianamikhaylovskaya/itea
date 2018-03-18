package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class LinkedInSearchPage extends LinkedinBasePage {
    @FindBy(xpath = "//li[contains(@class,'search-result__occluded-item')]")
    public List<WebElement> resultsWebElementList;

    @FindBy (xpath = "//h3[contains(@class,'search-results__total')]")
    public WebElement resultsNumber;

    public LinkedInSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public List<String> getResults() {
        waitUntilElementIsVisible(resultsNumber,10);
        List<String> resulsStringList = new ArrayList();
        for (WebElement result : resultsWebElementList) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", result);
            String cardTitle = result.getText();
            resulsStringList.add(cardTitle);
            //System.out.println("XXXX");
            //System.out.println(cardTitle);

        }
        return resulsStringList;
    }
}
