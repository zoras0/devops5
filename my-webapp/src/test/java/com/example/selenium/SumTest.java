package com.example.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {

    @Test
    public void testSum() {
        // Step 1: Set the path to your EdgeDriver
        System.setProperty("webdriver.edge.driver", "C:\\WebDriver\\Edge145\\msedgedriver.exe");

        // Step 2: Use headless options for Jenkins
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless=new");   // Headless mode
        options.addArguments("--no-sandbox");     // Recommended for CI
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new EdgeDriver(options);

        try {
            // Step 3: Open your webapp
            driver.get("file:///C:/Users/admin/my-webapp/src/main/webapp/index.html");

            // Step 4: Input numbers and click
            driver.findElement(By.id("num1")).sendKeys("10");
            driver.findElement(By.id("num2")).sendKeys("20");
            driver.findElement(By.tagName("button")).click();

            // Step 5: Verify result
            String result = driver.findElement(By.id("result")).getText();
            assertEquals("Sum: 30", result);

        } finally {
            driver.quit();
        }
    }
}