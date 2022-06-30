package businesslogic.flowmodels;

import businesslogic.Validations;
import businesslogic.pagemodels.ArticlePage;
import businesslogic.pagemodels.ArticlesPage;
import core.UserActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ArticleFlow extends UserActions {

    Validations validate;
    WebDriver driver;
    ArticlesPage articlesPage;
    ArticlePage articlePage;

    public ArticleFlow(WebDriver driver) {
        this.driver = driver;
        articlesPage = new ArticlesPage(this.driver);
        articlePage = new ArticlePage(this.driver);
    }
    public void openSztorikSubPage() {
        click(articlesPage.sztorikPageButton());
        validate.textIsPresentOnPage(driver, "Sztorik");
    }
    public void searchForArticle(String searchKeyword) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", articlesPage.searchInputBox());
        click(articlesPage.searchInputBox());
        articlesPage.searchInputBox().sendKeys(searchKeyword);
        click(articlesPage.searchSubmitButton());
        validate.elementIsDisplayedOnPage(articlesPage.pageHeader());
    }
    public void openFirstArticle() {
        click(articlesPage.firstArticle());
        validate.elementIsDisplayedOnPage(articlePage.pageHeader(),"article title");
        validate.elementIsDisplayedOnPage(articlePage.articleDate(),"article date");
        validate.elementIsDisplayedOnPage(articlePage.articleAuthor(),"article author");
    }
}
