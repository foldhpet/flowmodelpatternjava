package businesslogic.flowmodels;

import businesslogic.Validations;
import businesslogic.pagemodels.ArticlesPage;
import businesslogic.pagemodels.NewsPage;
import core.UserActions;
import org.openqa.selenium.WebDriver;

public class MenuFlow extends UserActions {

    Validations validate;
    NewsPage newsPage;
    ArticlesPage articlesPage;

    public MenuFlow(WebDriver driver) {
        validate = new Validations();
        newsPage = new NewsPage(driver);
        articlesPage = new ArticlesPage(driver);
    }

    public void clickCikkekMenuButton() {
        click(newsPage.cikkekMenuButton());
        validate.text("Cikkek", articlesPage.pageHeader());
    }
}
