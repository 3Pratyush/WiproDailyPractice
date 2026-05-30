package DP_Day_26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

    public static void main(String[] args)
            throws InterruptedException {

        // Create Report Location
        ExtentSparkReporter spark =
                new ExtentSparkReporter(
                        "./Reports/SeleniumReport.html");

        // Create Extent Report
        ExtentReports extent =
                new ExtentReports();

        extent.attachReporter(spark);

        // Create Test
        ExtentTest test =
                extent.createTest(
                        "SauceDemo Login Test");

        WebDriver driver =
                new ChromeDriver();

        driver.manage().window().maximize();

        try {

            // Open Website
            driver.get(
                    "https://www.saucedemo.com/");

            test.info("Website Opened");

            // Enter Username
            driver.findElement(By.id("user-name"))
                    .sendKeys("standard_user");

            test.info("Username Entered");

            // Enter Password
            driver.findElement(By.id("password"))
                    .sendKeys("secret_sauce");

            test.info("Password Entered");

            // Click Login
            driver.findElement(By.id("login-button"))
                    .click();

            test.info("Login Button Clicked");

            Thread.sleep(2000);

            // Validation
            String title =
                    driver.getTitle();

            if (title.contains("Swag")) {

                test.pass(
                        "Login Successful");
            } else {

                test.fail(
                        "Login Failed");
            }

        } catch (Exception e) {

            test.fail(
                    "Test Failed : "
                            + e.getMessage());
        }

        // Close Browser
        driver.quit();

        // Generate Report
        extent.flush();

        System.out.println(
                "Report Generated Successfully");
    }
}