package businesslogic.pagemodels;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArticlesPage extends BasePage {

    public ArticlesPage(WebDriver driver) {
        super(driver);
    }

    By pageHeaderLocator;
    By sztorikPageButtonLocator;
    By searchInputBoxLocator;
    By searchSubmitButtonFirstAlternateLocator;
    By searchSubmitButtonSecondAlternateLocator;
    By firstArticleLocator;

    //--- Locator setters ---
    protected void setPageHeaderLocator() {
        pageHeaderLocator = By.tagName("h1");
    }
    protected void setSztorikPageButtonLocator() {
        sztorikPageButtonLocator = By.partialLinkText("Sztorik");
    }
    protected void setSearchInputBoxLocator() {
        searchInputBoxLocator = By.className("msg-userinput");
    }
    protected void setSearchSubmitButtonFirstAlternateLocator() {
        searchSubmitButtonFirstAlternateLocator = By.xpath("/html/body/div[4]/div[2]/form/input[4]");
    }
    protected void setSearchSubmitButtonSecondAlternateLocator() {
        searchSubmitButtonSecondAlternateLocator = By.xpath("/html/body/div[4]/div[2]/form/input[4]");
    }
    protected void setFirstArticleLocator() {
        firstArticleLocator = By.xpath("/html/body/div[3]/div[2]/p[3]/span[1]/a");
    }

    //--- Webelements ---
    public WebElement pageHeader() {
        setPageHeaderLocator();
        return driver.findElement(pageHeaderLocator);
    }
    public WebElement sztorikPageButton() {
        setSztorikPageButtonLocator();
        return driver.findElement(sztorikPageButtonLocator);
    }
    public WebElement searchInputBox() {
        setSearchInputBoxLocator();
        return driver.findElement(searchInputBoxLocator);
    }
    public WebElement searchSubmitButton() {
        WebElement element;
        try {
            element = driver.findElement(By.xpath("/html/body/div[4]/div[2]/form/input[4]"));
        } catch (ElementNotInteractableException e) {
            element = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/input[3]"));
        }
        return element;
    }
    public WebElement firstArticle() {
        setFirstArticleLocator();
        return driver.findElement(firstArticleLocator);
    }
}
