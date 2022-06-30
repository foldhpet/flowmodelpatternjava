package businesslogic;

import core.Log;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Validations {

    public void text(String expectedText, WebElement element) {
        Log.debug("Expected text: " + expectedText);
        Log.debug("Actual text: " + element.getText());
        Assertions.assertEquals(expectedText, element.getText());
    }

    public void textIsPresentOnPage(WebDriver driver, String text) {
        Log.debug("Validating whether '" + text + "' is visible on the page.");
        Assertions.assertTrue(driver.getPageSource().contains(text));
    }

    public void elementIsDisplayedOnPage(WebElement element) {
        Log.debug("Validating whether '" + element.getText() + "' is visible on the page.");
        Assertions.assertTrue(element.isDisplayed());
    }

    public void elementIsDisplayedOnPage(WebElement element, String elementName) {
        Log.debug("Validating whether '" + elementName + "' is visible on the page.");
        Assertions.assertTrue(element.isDisplayed());
    }
}
