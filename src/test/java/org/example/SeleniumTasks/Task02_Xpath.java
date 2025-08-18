package org.example.SeleniumTasks;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Task02_Xpath {
    @Description("Find all the Xpaths and create the flow for the VWO website")
    @Test
    public void VWO_Free_Trial() throws InterruptedException {
        //Step-1> Open the browser and open the website link
        ChromeOptions chromeOptions =new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver =new ChromeDriver(chromeOptions);
        driver.get("https://app.vwo.com");

        //Step-2>Click on start free trial link
        WebElement free_trail_link =driver.findElement(By.xpath("//a[text()='Start a free trial']"));
        free_trail_link.click();

        //Step-3>Enter the email address, accept the persmissions and sign up in the free trial page
        WebElement email_address =driver.findElement(By.xpath("//input[@id='page-v1-step1-email']"));
        email_address.sendKeys("prateek@yopmail.com");
        WebElement checkbox =driver.findElement(By.xpath("//input[@id='page-free-trial-step1-cu-gdpr-consent-checkbox']"));
        checkbox.click();
        WebElement submit_button=driver.findElement(By.xpath("//button[text()='Create a Free Trial Account']"));
        submit_button.click();
       driver.quit();


    }
}
