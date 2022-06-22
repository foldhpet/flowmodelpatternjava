package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Timestamp;

public class BaseTest {
    String filename;
    String appName;
    protected WebDriver driver;

    @BeforeEach
    protected void setup() {
        // ezt majd propertyn keresztül kell majd állítani
        appName = "defaultAppName";
        filename = new Timestamp(System.currentTimeMillis()).toString();
        filename = filename.replaceAll("[^a-zA-Z0-9]", "");
        filename += "_" + appName + ".log";
        System.setProperty("logFilename", filename);
        Log.info("Setting log filename to: " + filename);

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @AfterEach
    protected void teardown() {
        driver.quit();
    }
}
