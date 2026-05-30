package DP_Day_22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ParaBankFundTransfer {

    public static void main(String[] args)
            throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(
        "https://parabank.parasoft.com/parabank/index.htm");

        driver.findElement(By.name("username"))
                .sendKeys("john");
        Thread.sleep(1000);

        driver.findElement(By.name("password"))
                .sendKeys("demo");
        Thread.sleep(1000);

        driver.findElement(By.xpath(
                "//input[@value='Log In']"))
                .click();

        Thread.sleep(3000);

        driver.findElement(By.linkText("Transfer Funds"))
                .click();

        Thread.sleep(2000);

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

        toAccount.selectByIndex(1);

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
                "Transfer Status : " + successMessage);

        Thread.sleep(2000);

        driver.findElement(By.linkText("Log Out"))
                .click();

        Thread.sleep(3000);

        driver.quit();
    }
}
