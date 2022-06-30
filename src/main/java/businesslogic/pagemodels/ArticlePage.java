package businesslogic.pagemodels;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArticlePage extends BasePage {

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    By pageHeaderLocator;
    By articleDateLocator;
    By articleAuthorLocator;

    //--- Locator setters ---
    protected void setPageHeaderLocator() {
        pageHeaderLocator = By.tagName("h1");
    }
    protected void setArticleDateLocator() {
        articleDateLocator = By.className("hir_datum");
    }
    protected void setArticleAuthorLocator() {
        articleAuthorLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div[1]/div/span");
    }

    //--- Webelements ---
    public WebElement pageHeader() {
        setPageHeaderLocator();
        return driver.findElement(pageHeaderLocator);
    }
    public WebElement articleDate() {
        setArticleDateLocator();
        return driver.findElement(articleDateLocator);
    }
    public WebElement articleAuthor() {
        setArticleAuthorLocator();
        return driver.findElement(articleAuthorLocator);
    }
}
