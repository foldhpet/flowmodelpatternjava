package test;

import businesslogic.BaseTest;
import businesslogic.UserActions;
import businesslogic.Validations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class StructuredScriptingTest extends BaseTest {

    UserActions action;
    Validations validate;

    @Test
    public void BokszTestPureScript() {
        driver.findElement(By.linkText("Cikkek")).click();
        Assertions.assertEquals("Cikkek",
                driver.findElement(By.id("content")).
                        findElement(By.tagName("h1")).getText());

        driver.findElement(By.partialLinkText("Sztorik")).click();
        Assertions.assertEquals(true,
                driver.getPageSource().contains("Sztorik"));
    }

    @Test
    public void BokszTestUsingCoreFunctionality() {
        action = new UserActions();
        validate = new Validations();

        action.click(driver.findElement(By.linkText("Cikkek")));
        validate.text("Cikkek", driver.findElement(By.id("content")).
                findElement(By.tagName("h1")));

        action.click(driver.findElement(By.partialLinkText("Sztorik")));
        validate.textIsPresentOnPage(driver, "Sztorik");
    }
}