package test;

import core.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Properties;

class LogUnstructured {
    private static final Logger LogUnstructured =  LogManager.getLogger(core.Log.class);

    public static void info (String message) {
        LogUnstructured.info(message);
    }

    public static void warn (String message) {
        LogUnstructured.warn(message);
    }

    public static void error (String message) {
        LogUnstructured.error(message);
    }

    public static void fatal (String message) {
        LogUnstructured.fatal(message);
    }

    public static void debug (String message) {
        LogUnstructured.debug(message);
    }
}

public class UnstructuredScriptingTest {

    @Test
    public void BokszTest() throws IOException {
        String appConfigPath = Thread.currentThread().getContextClassLoader().getResource("app.properties").getPath();
        Properties appProperties = new Properties();
        appProperties.load(new FileInputStream(appConfigPath));
        String appName = appProperties.getProperty("appName");

        String filename = new Timestamp(System.currentTimeMillis()).toString();
        filename = filename.replaceAll("[^a-zA-Z0-9]", "");
        filename += "_" + appName + ".log";
        System.setProperty("logFilename", filename);
        LogUnstructured.info("Set up log filename to: " + filename);
        LogUnstructured.info("Test suite execution started. For more detailed logging, set log level to debug before execution.");

        LogUnstructured.debug("Initiating webdriver.");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebElement element;
        driver.get("https://www.profiboksz.hu/");
        LogUnstructured.debug("Webdriver being used: " + driver.toString());

        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/ul/li[4]/a")).click();

        driver.findElement(By.linkText("Cikkek")).click();
        element = driver.findElement(By.tagName("h1"));
        LogUnstructured.debug("Expected text: Cikkek");
        LogUnstructured.debug("Actual text: " + element.getText());
        Assertions.assertEquals("Cikkek", element.getText());

        driver.findElement(By.partialLinkText("Sztorik")).click();
        LogUnstructured.debug("Validating whether 'Sztorik' is visible on the page.");
        Assertions.assertTrue(driver.getPageSource().contains("Sztorik"));

        element = driver.findElement(By.className("msg-userinput"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        element.sendKeys("Rocky");
        try {
            driver.findElement(By.xpath("/html/body/div[4]/div[2]/form/input[4]")).click();
        } catch (ElementNotInteractableException e) {
            driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/input[3]")).click();
        }
        element = driver.findElement(By.tagName("h1"));
        LogUnstructured.debug("Validating whether '" + element.getText() + "' is visible on the page.");
        Assertions.assertTrue(element.isDisplayed());

        driver.findElement(By.xpath("/html/body/div[3]/div[2]/p[3]/span[1]/a")).click();
        LogUnstructured.debug("Validating whether 'article title' is visible on the page.");
        Assertions.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());
        LogUnstructured.debug("Validating whether 'article date' is visible on the page.");
        Assertions.assertTrue(driver.findElement(By.className("hir_datum")).isDisplayed());
        LogUnstructured.debug("Validating whether 'article author' is visible on the page.");
        Assertions.assertTrue(driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[1]/div/span")).isDisplayed());

        driver.quit();
    }
}
