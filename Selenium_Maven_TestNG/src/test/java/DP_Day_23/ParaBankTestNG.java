package DP_Day_23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ParaBankTestNG {

    WebDriver driver;

    @BeforeTest
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(
        "https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test(priority = 1)
    public void registrationTest()
            throws InterruptedException {

        driver.findElement(By.linkText("Register"))
                .click();

        Thread.sleep(2000);

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

        System.out.println(
                "Registration Successful");
    }

    @Test(priority = 2)
    public void fundTransferTest()
            throws InterruptedException {

        driver.get(
        "https://parabank.parasoft.com/parabank/index.htm");

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

        driver.findElement(By.linkText(
                "Transfer Funds"))
                .click();

        Thread.sleep(3000);

        driver.findElement(By.id("amount"))
                .sendKeys("500");

        Thread.sleep(1000);

        Select fromAccount =
                new Select(driver.findElement(
                        By.id("fromAccountId")));

        fromAccount.selectByIndex(0);

        Thread.sleep(1000);

        Select toAccount =
                new Select(driver.findElement(
                        By.id("toAccountId")));

        toAccount.selectByIndex(0);

        Thread.sleep(1000);

        driver.findElement(By.xpath(
                "//input[@value='Transfer']"))
                .click();

        Thread.sleep(3000);

        String successMessage =
                driver.findElement(By.xpath(
                "//h1[@class='title']"))
                .getText();

        System.out.println(
                "Transfer Status : "
                + successMessage);

        Thread.sleep(3000);

        driver.findElement(By.linkText(
                "Log Out"))
                .click();

        Thread.sleep(3000);
    }

    @AfterTest
    public void closeBrowser() {

        driver.quit();
    }
}