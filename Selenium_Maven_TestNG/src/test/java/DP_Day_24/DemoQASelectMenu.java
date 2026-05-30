package DP_Day_24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQASelectMenu {

    public static void main(String[] args)
            throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/select-menu");

        Thread.sleep(3000);

        WebElement selectValue =
                driver.findElement(By.id("withOptGroup"));

        selectValue.click();

        Thread.sleep(2000);

        driver.findElement(By.xpath(
                "//div[text()='Group 1, option 1']"))
                .click();

        Thread.sleep(3000);

        WebElement selectOne =
                driver.findElement(By.id("selectOne"));

        selectOne.click();

        Thread.sleep(2000);

        driver.findElement(By.xpath(
                "//div[text()='Dr.']"))
                .click();

        Thread.sleep(3000);

        driver.findElement(By.id("oldSelectMenu"))
                .click();

        Thread.sleep(2000);

        driver.findElement(By.xpath(
                "//option[text()='Purple']"))
                .click();

        Thread.sleep(3000);

        System.out.println(
                "Select Menu Operations Completed Successfully");

        driver.quit();
    }
}