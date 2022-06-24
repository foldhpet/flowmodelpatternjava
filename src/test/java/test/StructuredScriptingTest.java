package test;

import businesslogic.PkszBaseTest;
import businesslogic.Validations;
import core.UserActions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class StructuredScriptingTest extends PkszBaseTest {

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