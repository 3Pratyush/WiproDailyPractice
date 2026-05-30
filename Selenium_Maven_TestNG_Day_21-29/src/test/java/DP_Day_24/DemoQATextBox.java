package DP_Day_24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQATextBox {

    public static void main(String[] args)
            throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/text-box");

        Thread.sleep(3000);

        driver.findElement(By.id("userName"))
                .sendKeys("Pratyush Sahoo");

        Thread.sleep(1000);

        driver.findElement(By.id("userEmail"))
                .sendKeys("pratyush@gmail.com");

        Thread.sleep(1000);

        driver.findElement(By.id("currentAddress"))
                .sendKeys("Bhubaneswar, Odisha");

        Thread.sleep(1000);

        driver.findElement(By.id("permanentAddress"))
                .sendKeys("KIIT Road, Bhubaneswar");

        Thread.sleep(1000);

        driver.findElement(By.id("submit"))
                .click();

        Thread.sleep(3000);

        System.out.println(
                "Text Box Form Submitted Successfully");

        driver.findElement(By.id("userName"))
                .clear();

        Thread.sleep(1000);

        driver.findElement(By.id("userEmail"))
                .clear();

        Thread.sleep(1000);

        driver.findElement(By.id("currentAddress"))
                .clear();

        Thread.sleep(1000);

        driver.findElement(By.id("permanentAddress"))
                .clear();

        Thread.sleep(2000);

        System.out.println(
                "All Inputs Cleared Successfully");

        driver.quit();
    }
}