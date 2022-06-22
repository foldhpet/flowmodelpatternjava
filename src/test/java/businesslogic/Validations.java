package businesslogic;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;

public class Validations {

    public void text(String expectedText, WebElement element) {
        Log.info("Expected text: " + expectedText);
        Log.info("Actual text: " + element.getText());
        Assertions.assertEquals(expectedText, element.getText());
    }

    public void textIsPresentOnPage(WebDriver driver, String text) {
        Log.info("Validating whether '" + text + "' is visible on the page.");
        Assertions.assertEquals(true,
                driver.getPageSource().contains(text));
    }
}
