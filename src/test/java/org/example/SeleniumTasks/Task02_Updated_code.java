package org.example.SeleniumTasks;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task02_Updated_code {
    @Description("Find all the Xpaths and create the flow for the VWO website")
    @Test
    public void VWO_Free_Trial() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);

        try {
            // Step-1: Open the website
            driver.get("https://app.vwo.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Step-2: Click on start free trial link
            WebElement free_trail_link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Start a free trial')]")));
            free_trail_link.click();

            // Step-3: Enter email, accept permissions, and sign up
            WebElement email_address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-v1-step1-email")));
            email_address.sendKeys("prateek@yopmail.com");

            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("page-free-trial-step1-cu-gdpr-consent-checkbox")));
            checkbox.click();

            WebElement submit_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Create a Free Trial Account')]")));
            submit_button.click();

        } finally {
            driver.quit();
        }
    }
}
