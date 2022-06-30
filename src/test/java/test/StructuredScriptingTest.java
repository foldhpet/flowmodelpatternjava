package test;

import businesslogic.PkszBaseTest;
import businesslogic.Validations;
import businesslogic.flowmodels.ArticleFlow;
import businesslogic.flowmodels.MenuFlow;
import businesslogic.pagemodels.ArticlePage;
import businesslogic.pagemodels.ArticlesPage;
import businesslogic.pagemodels.NewsPage;
import core.UserActions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

public class StructuredScriptingTest extends PkszBaseTest {

    @Test
    public void BokszTestUsingFlowModels() {
        MenuFlow menuFlow = new MenuFlow(driver);
        ArticleFlow articleFlow = new ArticleFlow(driver);

        menuFlow.clickCikkekMenuButton();
        articleFlow.openSztorikSubPage();
        articleFlow.searchForArticle("Rocky");
        articleFlow.openFirstArticle();
    }

    @Test
    public void BokszTestUsingPageModels() {
        UserActions action = new UserActions();
        Validations validate = new Validations();
        NewsPage newsPage = new NewsPage(driver);
        ArticlesPage articlesPage = new ArticlesPage(driver);
        ArticlePage articlePage = new ArticlePage(driver);

        action.click(newsPage.cikkekMenuButton());
        validate.text("Cikkek", articlesPage.pageHeader());

        action.click(articlesPage.sztorikPageButton());
        validate.textIsPresentOnPage(driver, "Sztorik");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", articlesPage.searchInputBox());
        action.click(articlesPage.searchInputBox());
        articlesPage.searchInputBox().sendKeys("Rocky");

        action.click(articlesPage.searchSubmitButton());
        validate.elementIsDisplayedOnPage(articlesPage.pageHeader());

        action.click(articlesPage.firstArticle());

        validate.elementIsDisplayedOnPage(articlePage.pageHeader(),"article title");
        validate.elementIsDisplayedOnPage(articlePage.articleDate(),"article date");
        validate.elementIsDisplayedOnPage(articlePage.articleAuthor(),"article author");
    }

    @Test
    public void BokszTestUsingCoreFunctionality() {
        UserActions action = new UserActions();
        Validations validate = new Validations();
        NewsPage newsPage = new NewsPage(driver);
        ArticlesPage articlesPage = new ArticlesPage(driver);

        //TODO: visszaállítani page model előttire
        action.click(newsPage.cikkekMenuButton());
        //TODO: visszaállítani page model előttire
        validate.text("Cikkek", articlesPage.pageHeader());

        action.click(driver.findElement(By.partialLinkText("Sztorik")));
        validate.textIsPresentOnPage(driver, "Sztorik");

        WebElement element = driver.findElement(By.className("msg-userinput"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        action.click(element);
        element.sendKeys("Rocky");
        try {
            action.click(driver.findElement(By.xpath("/html/body/div[4]/div[2]/form/input[4]")));
        } catch (ElementNotInteractableException e) {
            action.click(driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/input[3]")));
        }
        validate.elementIsDisplayedOnPage(driver.findElement(By.xpath("/html/body/div[3]/div[2]/h1")));

        action.click(driver.findElement(By.xpath("/html/body/div[3]/div[2]/p[3]/span[1]/a")));
        validate.elementIsDisplayedOnPage(driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/h1")),"article title");
        validate.elementIsDisplayedOnPage(driver.findElement(By.className("hir_datum")),"article date");
        validate.elementIsDisplayedOnPage(driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[1]/div/span")),"article author");
    }
}