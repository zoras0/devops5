package com.example.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {

    @Test
    public void testSum() {
        // Step 2: Set the path to your downloaded EdgeDriver
        System.setProperty("webdriver.edge.driver", "C:\\WebDriver\\Edge145\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        try {
            // Open your webapp
            driver.get("file:///C:/Users/admin/my-webapp/src/main/webapp/index.html");

            // Input numbers
            driver.findElement(By.id("num1")).sendKeys("10");
            driver.findElement(By.id("num2")).sendKeys("20");

            // Click button
            driver.findElement(By.tagName("button")).click();

            // Verify result
            String result = driver.findElement(By.id("result")).getText();
            assertEquals("Sum: 30", result);

        } finally {
            driver.quit();
        }
    }
}