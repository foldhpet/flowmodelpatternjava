package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Properties;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    String appConfigPath;
    String filename;
    String appName;
    protected WebDriver driver;

    @BeforeAll
    protected void setupOneTime() throws IOException {
        appConfigPath = Thread.currentThread().getContextClassLoader().getResource("app.properties").getPath();
        Properties appProperties = new Properties();
        appProperties.load(new FileInputStream(appConfigPath));
        appName = appProperties.getProperty("appName");

        filename = new Timestamp(System.currentTimeMillis()).toString();
        filename = filename.replaceAll("[^a-zA-Z0-9]", "");
        filename += "_" + appName + ".log";
        System.setProperty("logFilename", filename);
        Log.info("Set up log filename to: " + filename);
        Log.info("Test suite execution started. For more detailed logging, set log level to debug before execution.");
    }

    @BeforeEach
    protected void setup() {
        Log.debug("Initiating webdriver.");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        Log.debug("Webdriver being used: " + driver.toString());
    }

    @AfterEach
    protected void teardown() {
        driver.quit();
    }
}
