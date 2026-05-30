package DP_Day_27;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {

    WebDriver driver;

    @Parameters("browser")

    @Test
    public void loginTest(String browser)
            throws InterruptedException {

       
        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();

        } else {

            System.out.println(
                    "Invalid Browser");

            return;
        }

        driver.manage()
                .window()
                .maximize();

        driver.manage()
                .timeouts()
                .implicitlyWait(
                        Duration.ofSeconds(10));

        
        driver.get(
                "https://www.saucedemo.com/");

        driver.findElement(
                By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(
                By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(
                By.id("login-button"))
                .click();

        Thread.sleep(3000);

        String title =
                driver.getTitle();

        System.out.println(
                "Browser : "
                        + browser);

        System.out.println(
                "Page Title : "
                        + title);

        if (title.contains("Swag")) {

            System.out.println(
                    "Login Successful");

        } else {

            System.out.println(
                    "Login Failed");
        }
    }

    @AfterMethod
    public void closeBrowser() {

        driver.quit();
    }
}
