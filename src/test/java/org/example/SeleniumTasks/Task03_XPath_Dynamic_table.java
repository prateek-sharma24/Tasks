package org.example.SeleniumTasks;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Task03_XPath_Dynamic_table {
    @Test
    @Description("Verify the content for the dynamic table")
    @Owner("Prateek Sharma")
    public void test_table() throws InterruptedException {
        //Step-1>Open the browser and redirect to the website
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");

        //Step-2>Enter the valid username in the username field
        Thread.sleep(2000);
        WebElement username_field = driver.findElement(By.name("username"));
        username_field.sendKeys("admin");

        //Step-3>Enter the valid password in the password field
        WebElement password_field = driver.findElement(By.name("password"));
        password_field.sendKeys("Hacker@4321");

        //Step-4>Click on the login button in order to redirect to the dashboard page
        WebElement login_button = driver.findElement(By.xpath("//button[@type='submit']"));
        login_button.click();
        Thread.sleep(4000);

        //Step-5>Extract dynamic table
        Thread.sleep(3000); // wait for table to load

        String first_part = "//div[@role='table']/div[@class='oxd-table-body']/div[@class='oxd-table-card'][";
        String second_part = "]//div[@role='cell'][";
        String third_part = "]";

        // count rows
        int rows = driver.findElements(By.className("oxd-table-card")).size();

        // count columns in first row (so loop won’t break)
        int columns = driver.findElements(By.xpath(
                "//div[@class='oxd-table-body']/div[@class='oxd-table-card'][1]//div[@role='cell']"
        )).size();

        System.out.println("Table Data:");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                String final_part = first_part + i + second_part + j + third_part;
                String data = driver.findElement(By.xpath(final_part)).getText();
                System.out.print(data + " | ");
            }
            System.out.println();
        }
        driver.quit();
    }
}
