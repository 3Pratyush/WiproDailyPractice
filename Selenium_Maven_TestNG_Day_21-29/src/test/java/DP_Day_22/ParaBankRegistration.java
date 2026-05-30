package DP_Day_22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParaBankRegistration {

    public static void main(String[] args)
            throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(
        "https://parabank.parasoft.com/parabank/register.htm");

        driver.findElement(By.id("customer.firstName"))
                .sendKeys("Pratyush");
        Thread.sleep(1000);

        driver.findElement(By.id("customer.lastName"))
                .sendKeys("Sahoo");
        Thread.sleep(1000);

        driver.findElement(By.id("customer.address.street"))
                .sendKeys("KIIT Road");
        Thread.sleep(1000);

        driver.findElement(By.id("customer.address.city"))
                .sendKeys("Bhubaneswar");
        Thread.sleep(1000);

        driver.findElement(By.id("customer.address.state"))
                .sendKeys("Odisha");
        Thread.sleep(1000);

        driver.findElement(By.id("customer.address.zipCode"))
                .sendKeys("751024");
        Thread.sleep(1000);

        driver.findElement(By.id("customer.phoneNumber"))
                .sendKeys("9876543210");
        Thread.sleep(1000);

        driver.findElement(By.id("customer.ssn"))
                .sendKeys("123456789");
        Thread.sleep(1000);

        driver.findElement(By.id("customer.username"))
                .sendKeys("pratyush123");
        Thread.sleep(1000);

        driver.findElement(By.id("customer.password"))
                .sendKeys("Password@123");
        Thread.sleep(1000);

        driver.findElement(By.id("repeatedPassword"))
                .sendKeys("Password@123");
        Thread.sleep(1000);

        driver.findElement(By.xpath(
                "//input[@value='Register']"))
                .click();

        Thread.sleep(5000);

        driver.findElement(By.linkText("Log Out")).click();

        Thread.sleep(3000);

        driver.findElement(By.name("username"))
                .sendKeys("pratyush123");
        Thread.sleep(1000);

        driver.findElement(By.name("password"))
                .sendKeys("Password@123");
        Thread.sleep(1000);

        driver.findElement(By.xpath(
                "//input[@value='Log In']"))
                .click();

        Thread.sleep(5000);

        System.out.println(driver.getTitle());

        driver.quit();
    }
}