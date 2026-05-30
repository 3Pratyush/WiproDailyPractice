package DP_Day_24;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQAWebTables {

    public static void main(String[] args)
            throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/webtables");

        Thread.sleep(3000);

        driver.findElement(By.id("addNewRecordButton"))
                .click();

        Thread.sleep(2000);

        driver.findElement(By.id("firstName"))
                .sendKeys("Pratyush");

        Thread.sleep(1000);

        driver.findElement(By.id("lastName"))
                .sendKeys("Sahoo");

        Thread.sleep(1000);

        driver.findElement(By.id("userEmail"))
                .sendKeys("pratyush@gmail.com");

        Thread.sleep(1000);

        driver.findElement(By.id("age"))
                .sendKeys("22");

        Thread.sleep(1000);

        driver.findElement(By.id("salary"))
                .sendKeys("50000");

        Thread.sleep(1000);

        driver.findElement(By.id("department"))
                .sendKeys("QA");

        Thread.sleep(1000);

        driver.findElement(By.id("submit"))
                .click();

        Thread.sleep(3000);

        String tableData =
                driver.findElement(By.className(
                "rt-tbody"))
                .getText();

        System.out.println(
                "Web Table Data:");

        System.out.println(tableData);

        Thread.sleep(3000);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "window.scrollBy(0,500)");

        Thread.sleep(2000);

        driver.findElement(By.xpath(
                "(//span[@title='Edit'])[4]"))
                .click();

        Thread.sleep(2000);

        driver.findElement(By.id("salary"))
                .clear();

        Thread.sleep(1000);

        driver.findElement(By.id("salary"))
                .sendKeys("70000");

        Thread.sleep(1000);

        driver.findElement(By.id("submit"))
                .click();

        Thread.sleep(3000);

        driver.findElement(By.xpath(
                "(//span[@title='Delete'])[4]"))
                .click();

        Thread.sleep(3000);

        System.out.println(
                "Record Updated and Deleted Successfully");

        driver.quit();
    }
}