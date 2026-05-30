package DP_Day_25;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class PhpTravelsFlightSearch {

    public static void main(String[] args)
            throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Open PHP Travels Opposite
        driver.get("https://phptravels.net/");

        // Click Flights Tab
        driver.findElement(
                By.xpath("//a[contains(text(),'Flights')]"))
                .click();

        Thread.sleep(2000);

        // Enter From City
        driver.findElement(
                By.xpath("//input[@placeholder='Flying From']"))
                .sendKeys("Delhi");

        Thread.sleep(2000);

        // Select suggestion
        driver.findElement(
                By.xpath("//li[contains(text(),'Delhi')]"))
                .click();

        // Enter Destination City
        driver.findElement(
                By.xpath("//input[@placeholder='To Destination']"))
                .sendKeys("Mumbai");

        Thread.sleep(2000);

        // Select suggestion
        driver.findElement(
                By.xpath("//li[contains(text(),'Mumbai')]"))
                .click();

        // Click Search Button
        driver.findElement(
                By.id("flights-search"))
                .click();

        // Fluent Wait
        FluentWait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(Exception.class);

        // Wait until loading spinner disappears
        wait.until(driver1 -> {

            try {

                WebElement loader =
                        driver1.findElement(
                                By.className("loading"));

                return !loader.isDisplayed();

            } catch (Exception e) {

                return true;
            }
        });

        System.out.println(
                "Flight Search Results Displayed Successfully");

        // Close browser
        driver.quit();
    }
}
