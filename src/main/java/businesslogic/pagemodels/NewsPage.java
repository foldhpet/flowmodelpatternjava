package businesslogic.pagemodels;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewsPage extends BasePage {

    By cikkekMenuButtonLocator;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    protected void setCikkekMenuButtonLocator() {
        cikkekMenuButtonLocator = By.linkText("Cikkek");
    }

    public WebElement cikkekMenuButton() {
        setCikkekMenuButtonLocator();
        return driver.findElement(cikkekMenuButtonLocator);
    }
}
