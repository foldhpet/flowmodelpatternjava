package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UnstructuredScriptingTest {

    @Test
    public void BokszTest() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.profiboksz.hu/");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/ul/li[4]/a")).click();

        driver.quit();
    }
}
