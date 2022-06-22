package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UnstructuredScriptingWithSetupTeardownTest {

    protected WebDriver driver;

    @BeforeEach
    private void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @AfterEach
    private void teardown() {
        driver.quit();
    }

    @Test
    public void BokszTest() {
        driver.get("https://www.profiboksz.hu/");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/ul/li[4]/a")).click();
    }
}
