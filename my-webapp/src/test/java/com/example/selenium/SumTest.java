import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {

    @Test
    public void testSum() {
        // Automatically manage EdgeDriver version
        WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        WebDriver driver = new EdgeDriver(options);

        try {
            driver.get("file:///C:/Users/admin/my-webapp/src/main/webapp/index.html");

            driver.findElement(By.id("num1")).sendKeys("10");
            driver.findElement(By.id("num2")).sendKeys("20");

            driver.findElement(By.tagName("button")).click();

            String result = driver.findElement(By.id("result")).getText();
            assertEquals("Sum: 30", result);

        } finally {
            driver.quit();
        }
    }
}