package org.example.SeleniumTasks;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task01_Xpath {
    @Description("Verify that the user gets error message in order to login to the account")
    @Test
    public void orangehrm_login() {
        // Step-1: Open the website URL
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");

        // Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step-2: Enter username and password
        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Admin123");

        // Step-3: Click login and wait for error message
        WebElement login_button = driver.findElement(By.xpath("//button[@type='submit']"));
        login_button.click();

        WebElement error_message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Invalid credentials']"))
        );

        Assert.assertEquals(error_message.getText(), "Invalid credentials");

        driver.quit();
    }
}
