package businesslogic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    protected void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get("https://www.profiboksz.hu/");
    }

    @AfterEach
    protected void teardown() {
        driver.quit();
    }
}
